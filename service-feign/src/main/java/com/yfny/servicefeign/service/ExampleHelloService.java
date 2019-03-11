package com.yfny.servicefeign.service;

import com.yfny.servicepojo.entity.DemandEntity;
import com.yfny.servicepojo.entity.UserEntity;
import com.yfny.servicefeign.fallback.ExampleHelloServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 示例Service
 * Created by jisongZhou on 2019/2/14.
 **/

@FeignClient(value = "service-hello", fallback = ExampleHelloServiceHystric.class)
public interface ExampleHelloService {

    @RequestMapping(value = "/exampleHello/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/exampleHello/grade", method = RequestMethod.GET)
    String grade(@RequestParam(value = "goal") String goal);


    //登陆
    @GetMapping(value = "/user/login")
    public UserEntity login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);

    //提交需求单
    @PostMapping(value = "/demand/submitDemand")
    int submitDemand(@RequestBody DemandEntity demandEntity);

    @PostMapping(value = "/demand/auditDemand")
    int auditDemand(@RequestParam Long demandId,@RequestParam String taskId,@RequestParam String auditOpinion,@RequestParam String shrId,@RequestParam String orgId,@RequestParam boolean pass);

    @GetMapping(value = "/demand/selectDemandByUserId/{userId}/{pageNum}/{pageSize}")
    List<DemandEntity> selectDemandByUserId(@PathVariable String userId,@PathVariable int pageNum,@PathVariable int pageSize);

    @RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public boolean addUser();
}
