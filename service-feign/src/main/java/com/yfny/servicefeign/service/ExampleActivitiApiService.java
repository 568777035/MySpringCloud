package com.yfny.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@FeignClient(value = "activity-api")
public interface ExampleActivitiApiService {



    @PostMapping(value = "/activitiApi/createTask")
    String createTask(@RequestParam String userId, @RequestParam String key, @RequestBody Map<String,Object> variables);

    @PostMapping(value = "/activitiApi/fulfilTask")
    String fulfilTask(@RequestParam String taskId,@RequestBody Map<String,Object> variables);


}
