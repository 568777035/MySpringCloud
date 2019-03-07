package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleActivitiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@RestController
@RequestMapping(value = "/activitiApi")
public class ActivitiApiController {

    @Autowired
    private ExampleActivitiApiService exampleActivitiApiService;

    @GetMapping(value = "/submitDemand/{userId}/{createName}/{zzid}/{demandReviews}")
    public String createTask(@PathVariable String userId,@PathVariable String createName, @PathVariable String zzid, @PathVariable String demandReviews){
       int i = exampleActivitiApiService.submitDemand(userId,createName,demandReviews,zzid);
       if (i==1){
           return "创建成功!!";
       }else {
           return "创建失败!!";
       }
    }
}
