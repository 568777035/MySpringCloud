package com.yfny.servicefeign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jisongZhou on 2019/2/13.
 **/

@FeignClient(value = "service-tips")
public interface SchedualServiceTips {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/tips", method = RequestMethod.GET)
    String tips();
}
