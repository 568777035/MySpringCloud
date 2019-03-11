package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleActivitiApiService;
import com.yfny.servicefeign.service.ExampleHelloService;
import com.yfny.servicepojo.entity.DemandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需求单Controller
 * <p>
 * Created  by  jinboYu  on  2019/3/6
 */
@RestController
@RequestMapping("/demand")
public class DemandController {

    @Autowired
    private ExampleActivitiApiService exampleActivitiApiService;

    @Autowired
    private ExampleHelloService exampleHelloService;

    @PostMapping(value = "/submitDemand")
    public String submitDemand(@RequestParam String createById,@RequestParam String createByName, @RequestParam String demandName, @RequestParam String demandDescription, @RequestParam String orgId){
        Map<String,Object> map = new HashMap<>();
        map.put("createName",createByName);
        map.put("orgId",orgId);
        map.put("demandDescription",demandDescription);
        String taskId = exampleActivitiApiService.createTask(createById,"xqd",map);
        if (taskId!=null){
            DemandEntity demandEntity = new DemandEntity();
            demandEntity.setCreateById(createById);
            demandEntity.setDemandDescription(demandDescription);
            demandEntity.setCreateByName(createByName);
            demandEntity.setOrgId(orgId);
            demandEntity.setTaskId(taskId);
            demandEntity.setDemandName(demandName);
            int j = exampleHelloService.submitDemand(demandEntity);
            if (j==1){
                return "需求单提交成功！！";
            }else {
                return "需求单提交失败！！";
            }
        }else {
            return "需求单提交失败，创建流程失败！！";
        }
    }

    /**
     * 审核需求单
     * @param demandId  需求单ID
     * @param taskId    流程任务ID
     * @param auditOpinion  审核意见
     * @param shrId 审核人ID
     * @param orgId 审核人组织ID
     * @param pass  是否通过
     * @return
     */
    @PostMapping(value = "/auditDemand")
    public String auditDemand(@RequestParam Long demandId,@RequestParam String taskId,@RequestParam String auditOpinion,@RequestParam String shrId,@RequestParam String orgId,@RequestParam boolean pass){
        Map<String,Object> map = new HashMap<>();
        map.put("shrId",shrId);
        map.put("auditOpinion",auditOpinion);
        map.put("pass",pass);
        taskId = exampleActivitiApiService.fulfilTask(taskId,map);
        if (taskId!=null){
            int i = exampleHelloService.auditDemand(demandId,taskId,auditOpinion,shrId,orgId,pass);
            if (i>0){
                return "审核通过！！";
            }else {
                return "审核失败！！";
            }
        }

        return "";
    }

    /**
     * 根据创建人ID查询需求单
     * @param userId    创建人ID
     * @param pageNum   当前页数
     * @param pageSize  显示数量
     * @return
     */
    @GetMapping(value = "/selectDemandByUserId/{userId}/{pageNum}/{pageSize}")
    public List<DemandEntity> selectDemandByUserId(@PathVariable String userId,@PathVariable int pageNum,@PathVariable int pageSize){
        return exampleHelloService.selectDemandByUserId(userId,pageNum,pageSize);
    }
}
