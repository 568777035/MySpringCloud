package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleHelloService;
import com.yfny.servicefeign.service.ExampleTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例Controller
 * Created by jisongZhou on 2019/2/14.
 **/

@RestController
public class ExampleController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private ExampleHelloService exampleHelloService;

    @Autowired
    private ExampleTipsService exampleTipsService;

    @GetMapping(value = "/hello1")
    public String hello1(@RequestParam String name) {
        return exampleHelloService.hello(name);
    }

    @GetMapping(value = "/hello2")
    public String hello2(@RequestParam String name) {
        return exampleTipsService.hello(name);
    }

    @GetMapping(value = "/grade")
    public String grade(@RequestParam String goal) {
        return exampleHelloService.grade(goal);
    }
}
