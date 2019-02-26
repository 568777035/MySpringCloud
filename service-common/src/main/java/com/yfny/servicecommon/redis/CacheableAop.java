package com.yfny.servicecommon.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存自定义注解实现
 * Created by jisongZhou on 2017/12/21.
 **/
@Aspect
@Component
public class CacheableAop implements Ordered {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(cache)")
    public Object cached(final ProceedingJoinPoint pjp, Cacheable cache)
            throws Throwable {
        Object value = null;
        int i = 0;
        try {
            String key = getCacheKey(pjp, cache);
            ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
            value = valueOper.get(key); // 从缓存获取数据
            if (value != null)
                return value; // 如果有数据,则直接返回

            value = pjp.proceed(); // 跳过缓存,到后端查询数据
            if (cache.expire() <= 0) { // 如果没有设置过期时间,则无限期缓存
                valueOper.set(key, value);
            } else { // 否则设置缓存时间
                valueOper.set(key, value, cache.expire(), TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        } finally {
            if (i > 0) {
                value = pjp.proceed(); // 跳过缓存,到后端查询数据
            }
        }
        return value;
    }

    @Around("@annotation(evict)")
    public Object evictCache(ProceedingJoinPoint jp, CacheEvict evict) throws Throwable {
        // 得到被代理的方法
        Method me = ((MethodSignature) jp.getSignature()).getMethod();
        // 得到被代理的方法上的注解
        String modelType = me.getAnnotation(CacheEvict.class).type();

        // 清除对应缓存
        redisTemplate.delete(modelType);

        return jp.proceed(jp.getArgs());
    }

    /**
     * 获取缓存的key值
     *
     * @param pjp   切点
     * @param cache 缓存
     * @return 键值
     */
    private String getCacheKey(ProceedingJoinPoint pjp, Cacheable cache) {

        StringBuilder buf = new StringBuilder();
        // buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());
        // System.out.println(pjp.getSignature().getDeclaringTypeName());
        // System.out.println(pjp.getSignature().getName());
        // if(cache.key().length()>0) {
        // buf.append(".").append(cache.key());
        // System.out.println(cache.key());
        // }

        // if(cache.type().length()>0) {
        // buf.append(pjp.getSignature().getName());
        // buf.append("_").append(cache.type());
        // System.out.println(cache.type());
        // }
        //buf.append(pjp.getTarget().getClass().getName());
        buf.append(pjp.getTarget().getClass().getSimpleName());
        buf.append("_").append(pjp.getSignature().getName());

        Object[] args = pjp.getArgs();
        if (cache.keyMode() == Cacheable.KeyMode.DEFAULT) {
            Annotation[][] pas = ((MethodSignature) pjp.getSignature())
                    .getMethod().getParameterAnnotations();
            for (int i = 0; i < pas.length; i++) {
                for (Annotation an : pas[i]) {
                    if (an instanceof CacheKey) {
                        buf.append("_").append(args[i].toString());
                        //System.out.println(args[i].toString());
                        break;
                    }
                }
            }
        } else if (cache.keyMode() == Cacheable.KeyMode.BASIC) {
            for (Object arg : args) {
                if (arg instanceof String) {
                    buf.append(".").append(arg);
                } else if (arg instanceof Integer || arg instanceof Long
                        || arg instanceof Short) {
                    buf.append(".").append(arg.toString());
                } else if (arg instanceof Boolean) {
                    buf.append(".").append(arg.toString());
                }
            }
        } else if (cache.keyMode() == Cacheable.KeyMode.ALL) {
            for (Object arg : args) {
                buf.append(".").append(arg.toString());
            }
        }

        return buf.toString();
    }

    @Override
    public int getOrder() {
        return 1002;
    }
}
