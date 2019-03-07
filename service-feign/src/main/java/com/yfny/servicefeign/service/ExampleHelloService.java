package com.yfny.servicefeign.service;

import com.yfny.servicepojo.entity.UserEntity;
import com.yfny.servicefeign.fallback.ExampleHelloServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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


    //登陆
    @GetMapping(value = "/user/login")
    public UserEntity login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);

    //提交需求单
    @GetMapping("/demand/submitDemand")
    int submitDemand(@RequestParam String createById,@RequestParam String createByName, @RequestParam String demandName, @RequestParam String demandStatus, @RequestParam String demandDescription, @RequestParam String orgId);
}
