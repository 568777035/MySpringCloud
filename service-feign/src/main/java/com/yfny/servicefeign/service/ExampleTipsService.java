package com.yfny.servicefeign.service;

import com.yfny.servicepojo.entity.OrderEntity;
import com.yfny.servicefeign.fallback.ExampleTipsServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例Service
 * Created by jisongZhou on 2019/2/14.
 **/

@FeignClient(value = "service-tips", fallback = ExampleTipsServiceHystric.class)
public interface ExampleTipsService {

    @RequestMapping(value = "/exampleTips/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/exampleTips/excellent", method = RequestMethod.GET)
    String excellent();

    @RequestMapping(value = "/exampleTips/good", method = RequestMethod.GET)
    String good();

    @RequestMapping(value = "/exampleTips/pass", method = RequestMethod.GET)
    String pass();

    @RequestMapping(value = "/exampleTips/fail", method = RequestMethod.GET)
    String fail();

    @RequestMapping(value = "/exampleTips/out", method = RequestMethod.GET)
    String out();

    @RequestMapping(value = "/exampleTips/error", method = RequestMethod.GET)
    String error();

    @GetMapping("/order/getOrderByPermission")
    public OrderEntity getOrderByPermission(@RequestParam(value = "permission") String permission);

    @RequestMapping(value = "/order/addOrder",method = RequestMethod.POST)
    public boolean addOrder();

}
