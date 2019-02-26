package com.yfny.servicecommon.redis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Redis缓存自定义注解清除
 * Created by jisongZhou on 2017/12/21.
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
public @interface CacheEvict {
    public String type() default "";    //业务类型
}