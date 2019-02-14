package com.yfny.servicehello.service;

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

    public String hello(String name) {
        return "service-hello -- hello " + name + " ,i am from port:" + port;
    }
}
