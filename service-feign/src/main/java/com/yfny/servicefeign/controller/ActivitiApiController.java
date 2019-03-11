package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleActivitiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@RestController
@RequestMapping(value = "/activitiApi")
public class ActivitiApiController {

    @Autowired
    private ExampleActivitiApiService exampleActivitiApiService;

    @PostMapping(value = "/createTask")
    public String createTask(@RequestParam String userId, @RequestParam String key, @RequestBody Map<String,Object> variables){
       String taskId = exampleActivitiApiService.createTask(userId,key,variables);
       if (taskId!=null){
           return "创建成功!!";
       }else {
           return "创建失败!!";
       }
    }
}
