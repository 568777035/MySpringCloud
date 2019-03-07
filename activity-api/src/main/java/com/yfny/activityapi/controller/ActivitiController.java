package com.yfny.activityapi.controller;

import com.yfny.activityapi.utils.ActivitiUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
@RestController
@RequestMapping(value = "/activitiApi")
public class ActivitiController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private HistoryService historyService;

    /**
     * 提交需求单
     * @param createName    创建人
     * @param zzid  组织ID
     * @param demandReviews 需求综述
     * @return
     */
    @GetMapping(value = "/submitDemand/{userId}/{createName}/{zzid}/{demandReviews}")
    public int  submitDemand(@PathVariable String userId,@PathVariable String createName, @PathVariable String zzid, @PathVariable String demandReviews){
        try {
            //查询第一个任务
            Task task = taskService.createTaskQuery().processInstanceId(ActivitiUtils.getProcessInstance(userId).getId()).singleResult();
            //设置流程变量
            Map<String,Object> variables = new HashMap<>();
            variables.put("createName",createName);
            variables.put("zzid",zzid);
            variables.put("demandReviews",demandReviews);
            taskService.setVariables(task.getId(),variables);
            //完成任务
            taskService.complete(task.getId());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 审核需求单
     * @param taskId    流程任务ID
     * @param auditOpinion  审核意见
     * @param shrId 审核人ID
     * @param pass  是否通过
     * @return 1成功，0失败
     */
    @GetMapping(value = "/auditDemand/{taskId}/{shrId}/{auditOpinion}/{pass}")
    public int auditDemand(@PathVariable String taskId,@PathVariable String auditOpinion,@PathVariable String shrId,@PathVariable boolean pass){
        try {
            //根据流程任务ID获取流程任务
            Map<String,Object> variables = new HashMap<>();
            variables.put("auditOpinion",auditOpinion);
            variables.put("shrId",shrId);
            variables.put("pass",pass);
            taskService.setVariables(taskId,variables);
            //完成任务
            taskService.complete(taskId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 修改需求单
     * @param taskId    流程任务ID
     * @param demandReviews 需求综述
     * @param zzid  组织ID
     * @return
     */
    @GetMapping(value = "/modifierDemand/{taskId}/{demandReviews}/{zzid}")
    public int modifierDemand(@PathVariable String taskId,@PathVariable String demandReviews,@PathVariable String zzid){
        try {
            //根据流程任务ID获取流程任务
            Map<String,Object> variables = new HashMap<>();
            variables.put("demandReviews",demandReviews);
            variables.put("zzid",zzid);
            taskService.setVariables(taskId,variables);
            //完成任务
            taskService.complete(taskId);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 根据分组ID获取任务列表，带分页
     * @param groupId   分组ID
     * @param pageNum   当前页数
     * @param pageSize  显示数量
     * @return
     */
    @GetMapping(value = "/getDemandByGroupId/{groupId}/{pageNum}/{pageSize}")
    public String getDemandByGroupId(@PathVariable String groupId,@PathVariable int pageNum,@PathVariable int pageSize){
        pageNum = (pageNum-1)*pageSize;
        List<Map<String,Object>> resultList = new ArrayList<>();
        //根据分组ID获取任务列表，不包含流程变量
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(groupId).listPage(pageNum,pageSize);
        //根据分组ID获取任务列表，包含流程变量
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(groupId).includeProcessVariables().listPage(pageNum,pageSize);
        if (tasks!=null && tasks.size()>0){
            for (Task task : tasks) {
                Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("任务名称",task.getName());
                resultMap.put("任务ID",task.getId());
                resultMap.put("组织ID",task.getProcessVariables().get("zzid"));
                resultMap.put("创建人",task.getProcessVariables().get("createName"));
                resultMap.put("需求描述",task.getProcessVariables().get("demandReviews"));
                resultList.add(resultMap);
            }
            JSONArray jsonArray = new JSONArray(resultList.toString());
            return jsonArray.toString();
        }else {
            return "获取成功，该组织下任务数: 0 ";
        }
    }

    /**
     * 根据当前用户Id获取任务列表,带分页
     * @param userId    用户ID
     * @param pageNum   当前页数
     * @param pageSize  显示数量
     * @return
     */
    @GetMapping(value = "/getDemandByUserId/{userId}/{pageNum}/{pageSize}")
    public String getDemandByUserId(@PathVariable String userId,@PathVariable int pageNum,@PathVariable int pageSize){
        pageNum = (pageNum-1)*pageSize;
        List<HistoricProcessInstance> historicProcessInstanceList = historyService.createHistoricProcessInstanceQuery().includeProcessVariables().startedBy(userId).listPage(pageNum,pageSize);
        if (historicProcessInstanceList!=null && historicProcessInstanceList.size()>0){
            for (HistoricProcessInstance historicProcessInstance : historicProcessInstanceList) {
                Task task = taskService.createTaskQuery().processInstanceId(historicProcessInstance.getId()).includeProcessVariables().singleResult();

                System.out.println("任务ID："+task.getId());
            }
            return "获取成功，该组织下任务数:"+historicProcessInstanceList.size();
        }else {
            return "获取成功，该组织下任务书: 0 ";
        }
    }
}
