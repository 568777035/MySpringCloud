package com.yfny.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@FeignClient(value = "activitiy-api")
public interface ExampleActivitiApiService {

    /**
     * 提交需求单
     * @param userId
     * @param createName
     * @param zzid
     * @param demandReviews
     * @return
     */
    @GetMapping(value = "/activitiApi/submitDemand/{userId}/{createName}/{zzid}/{demandReviews}")
    int submitDemand(@PathVariable String userId,@PathVariable String createName, @PathVariable String zzid, @PathVariable String demandReviews);
}
