package com.yfny.servicefeign.fallback;

import com.yfny.servicecommon.pojo.UserEntity;
import com.yfny.servicefeign.service.ExampleHelloService;
import org.springframework.stereotype.Component;

/**
 * 示例断路处理
 * Created by jisongZhou on 2019/2/14.
 **/

@Component
public class ExampleHelloServiceHystric implements ExampleHelloService {
    
    @Override
    public String hello(String name) {
        return "服务接口 [hello] 挂掉了！";
    }

    @Override
    public String grade(String goal) {
        return "服务接口 [grade] 挂掉了！";
    }



    @Override
    public UserEntity login(String username, String password) {
        return null;
    }
}
