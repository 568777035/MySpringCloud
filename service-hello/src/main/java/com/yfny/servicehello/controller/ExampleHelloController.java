package com.yfny.servicehello.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yfny.servicehello.service.ExampleHelloServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 示例Controller
 * Created by jisongZhou on 2019/2/14.
 **/

@RestController
@RequestMapping("/exampleHello")
public class ExampleHelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExampleHelloServiceImpl exampleHelloService;

    private static final Logger LOG = Logger.getLogger(ExampleHelloController.class.getName());

    @Value("${service.tips-url}")
    String url;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam(value = "name", defaultValue = "yfny") String name) {
        return exampleHelloService.hello(name);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

    @RequestMapping("/grade")
    public String grade(@RequestParam(value = "goal", defaultValue = "0") String goal) {
        LOG.log(Level.INFO, "calling trace service-tips");
        String goalResult = restTemplate.getForObject(url + "example/error", String.class);
        if (StringUtils.isNumeric(goal)) {
            double goalInt = Double.parseDouble(goal);
            if (goalInt >= 90 && goalInt <= 100) {
                goalResult = restTemplate.getForObject(url + "example/excellent", String.class);
            } else if (goalInt >= 70 && goalInt < 90) {
                goalResult = restTemplate.getForObject(url + "example/good", String.class);
            } else if (goalInt >= 60 && goalInt < 70) {
                goalResult = restTemplate.getForObject(url + "example/pass", String.class);
            } else if (goalInt >= 0 && goalInt < 60) {
                goalResult = restTemplate.getForObject(url + "example/fail", String.class);
            } else {
                goalResult = restTemplate.getForObject(url + "example/out", String.class);
            }
        }
        return goalResult;
    }

}
