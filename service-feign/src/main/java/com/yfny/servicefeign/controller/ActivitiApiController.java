package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleActivitiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@RestController
@RequestMapping(value = "/activitiApi")
public class ActivitiApiController {

    @Autowired
    private ExampleActivitiApiService exampleActivitiApiService;

    @PostMapping(value = "/submitDemand/{userId}/{createName}/{zzid}/{demandReviews}")
    public String createTask(@PathVariable String userId,@PathVariable String createName, @PathVariable String zzid, @PathVariable String demandReviews){
       String taskId = exampleActivitiApiService.submitDemand(userId,createName,demandReviews,zzid);
       if (taskId!=null){
           return "创建成功!!";
       }else {
           return "创建失败!!";
       }
    }
}
