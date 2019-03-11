package com.yfny.servicefeign.fallback;

import com.yfny.servicepojo.entity.DemandEntity;
import com.yfny.servicepojo.entity.UserEntity;
import com.yfny.servicefeign.service.ExampleHelloService;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public int submitDemand(DemandEntity demandEntity) {
        return 0;
    }

    @Override
    public int auditDemand(Long demandId, String taskId, String auditOpinion, String shrId, String orgId, boolean pass) {
        return 0;
    }

    @Override
    public List<DemandEntity> selectDemandByUserId(String userId, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public boolean addUser() {
        return false;
    }

}
