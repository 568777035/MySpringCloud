package com.yfny.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@FeignClient(value = "activity-api")
public interface ExampleActivitiApiService {

    /**
     * 提交需求单
     * @param userId
     * @param createName
     * @param zzid
     * @param demandReviews
     * @return
     */
    @PostMapping(value = "/activitiApi/submitDemand/{userId}/{createName}/{zzid}/{demandReviews}")
    String submitDemand(@PathVariable String userId,@PathVariable String createName, @PathVariable String zzid, @PathVariable String demandReviews);

    @PostMapping(value = "/activitiApi/auditDemand/{taskId}/{shrId}/{auditOpinion}/{pass}")
    String auditDemand(@PathVariable String taskId,@PathVariable String shrId,@PathVariable String auditOpinion,@PathVariable boolean pass);


}
