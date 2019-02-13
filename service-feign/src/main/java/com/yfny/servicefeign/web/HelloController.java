package com.yfny.servicefeign.web;

import com.yfny.servicefeign.clients.SchedualServiceHello;
import com.yfny.servicefeign.clients.SchedualServiceTips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jisongZhou on 2019/2/2.
 **/

@RestController
public class HelloController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHello schedualServiceHello;
    @Autowired
    SchedualServiceTips schedualServiceTips;

    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam String name) {
        return schedualServiceHello.sayHelloFromClientOne(name);
    }

    @GetMapping(value = "/tips")
    public String tips() {
        return schedualServiceHello.tips();
    }

    @GetMapping(value = "/info")
    public String info() {
        return schedualServiceHello.info();
    }

    @GetMapping(value = "/hello1")
    public String sayHello1(@RequestParam String name) {
        return schedualServiceTips.sayHelloFromClientOne(name);
    }

    @GetMapping(value = "/tips1")
    public String tips1() {
        return schedualServiceTips.tips();
    }
}
