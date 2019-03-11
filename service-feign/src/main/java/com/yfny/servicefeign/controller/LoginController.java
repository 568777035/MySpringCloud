package com.yfny.servicefeign.controller;

import com.yfny.servicecommon.businesslog.BusinessLog;
import com.yfny.servicefeign.service.UserServiceImpl;
import com.yfny.servicepojo.entity.OrderEntity;
import com.yfny.servicepojo.entity.UserEntity;
import com.yfny.servicefeign.service.ExampleHelloService;
import com.yfny.servicefeign.service.ExampleTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zileShi on 2019/2/26.
 **/

@Controller
@RequestMapping("/user")
public class LoginController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private ExampleHelloService exampleHelloService;

    @Autowired
    private ExampleTipsService exampleTipsService;

    @Autowired
    private UserServiceImpl userService;


    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @GetMapping(value = "/login")
    @ResponseBody
    @BusinessLog
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        UserEntity user = exampleHelloService.login(username,password);
        if (user != null){
            OrderEntity order = exampleTipsService.getOrderByPermission(user.getPermission());
            user.setFunction(order.getFunction());
            return "登陆成功！";
        }else {
            return "账号或密码错误！";
        }
    }


    @PostMapping(value = "/test")
    @ResponseBody
    public String test(){
        boolean result1 = userService.addUserAndOrder();
        System.out.println("result1 = " + result1);
        if (result1){
            return "true";
        }else {
            return "false";
        }
    }



}
