package com.yfny.servicetips.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yfny.servicetips.service.ExampleTipsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * 示例Controller
 * Created by jisongZhou on 2019/2/14.
 **/

@RestController
@RequestMapping("/exampleTips")
public class ExampleTipsController {

    private static final Logger LOG = Logger.getLogger(ExampleTipsController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExampleTipsServiceImpl exampleTipsServiceImpl;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam(value = "name", defaultValue = "yfny") String name) throws Exception {
        //Thread.sleep(3000);
        return "service-tips -- hello " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

    @RequestMapping("/excellent")
    @HystrixCommand
    public String excellent() {
        int i = 1/0;
        return "分数成绩优秀！";
    }

    @RequestMapping("/good")
    @HystrixCommand
    public String good() {
        return "分数成绩良好！";
    }

    @RequestMapping("/pass")
    @HystrixCommand
    public String pass() {
        return "分数成绩及格！";
    }

    @RequestMapping("/fail")
    @HystrixCommand
    public String fail() {
        return "分数成绩不及格！";
    }

    @RequestMapping("/out")
    @HystrixCommand
    public String out() {
        return "输入的分数不在规定范围内！";
    }

    @RequestMapping("/error")
    @HystrixCommand
    public String error() {
        return "输入的内容不符合格式规范！";
    }

}
