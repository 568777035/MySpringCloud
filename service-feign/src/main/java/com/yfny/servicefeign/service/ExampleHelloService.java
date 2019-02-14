package com.yfny.servicefeign.service;

import com.yfny.servicefeign.fallback.ExampleHelloServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例Service
 * Created by jisongZhou on 2019/2/14.
 **/

@FeignClient(value = "service-hello", fallback = ExampleHelloServiceHystric.class)
public interface ExampleHelloService {

    @RequestMapping(value = "/exampleHello/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/exampleHello/grade", method = RequestMethod.GET)
    String grade(@RequestParam(value = "goal") String goal);

}
