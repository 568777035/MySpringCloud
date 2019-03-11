package com.yfny.servicefeign.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zileShi on 2019/3/8.
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private ExampleHelloService exampleHelloService;

    @Autowired
    private ExampleTipsService exampleTipsService;


    /**
     * 分布式事务参考地址：
     *  https://www.txlcn.org/zh-cn/docs/demo/springcloud.html
     * @return
     */
    @LcnTransaction //分布式事务注解
    @Transactional
    public boolean addUserAndOrder(){
        boolean result = false;

        boolean res1 = exampleHelloService.addUser();

        System.out.println("res1 = " + res1);


        boolean res2 = exampleTipsService.addOrder();

        System.out.println("res2 = " + res2);

        //测试报错后数据是否回滚
        //System.out.println(10/0);

        if (res1 == true && res2 == true){
            result = true;
        }
        return result;
    }



}
