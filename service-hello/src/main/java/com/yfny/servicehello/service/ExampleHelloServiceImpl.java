package com.yfny.servicehello.service;

import com.yfny.servicecommon.redis.CacheKey;
import com.yfny.servicecommon.redis.Cacheable;
import com.yfny.servicecommon.redis.CommonCacheTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例Service实现
 * Created by jisongZhou on 2019/2/14.
 **/

@Service
public class ExampleHelloServiceImpl {

    @Value("${server.port}")
    String port;

    @Cacheable(expire = CommonCacheTime.ONE_DAY)
    public String hello(@CacheKey String name) {
        return "service-hello -- hello " + name + " ,i am from port:" + port;
    }
}
