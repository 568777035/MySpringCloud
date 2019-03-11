package com.yfny.servicefeign.fallback;

import com.yfny.servicepojo.entity.OrderEntity;
import com.yfny.servicefeign.service.ExampleTipsService;
import org.springframework.stereotype.Component;

/**
 * 示例断路处理
 * Created by jisongZhou on 2019/2/14.
 **/

@Component
public class ExampleTipsServiceHystric implements ExampleTipsService {

    @Override
    public String hello(String name) {
        return "服务接口 [hello] 挂掉了！";
    }

    @Override
    public String excellent() {
        return "服务接口 [excellent] 挂掉了！";
    }

    @Override
    public String good() {
        return "服务接口 [good] 挂掉了！";
    }

    @Override
    public String pass() {
        return "服务接口 [pass] 挂掉了！";
    }

    @Override
    public String fail() {
        return "服务接口 [fail] 挂掉了！";
    }

    @Override
    public String out() {
        return "服务接口 [out] 挂掉了！";
    }

    @Override
    public String error() {
        return "服务接口 [error] 挂掉了！";
    }


    @Override
    public OrderEntity getOrderByPermission(String permission) {
        return null;
    }

    @Override
    public boolean addOrder() {
        return false;
    }
}
