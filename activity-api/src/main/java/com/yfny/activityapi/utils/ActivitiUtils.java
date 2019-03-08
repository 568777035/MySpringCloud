package com.yfny.activityapi.utils;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;


/**
 * <p>
 * Created  by  jinboYu  on  2019/3/5
 */
public class ActivitiUtils {

    private static final ProcessInstance processInstance = null;

    /**
     * 启动流程
     * @return
     */
    public static ProcessInstance getProcessInstance(String userId){
        if (processInstance==null){
            //获取流程引擎对象
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            //设置流程发起人
            processEngine.getIdentityService().setAuthenticatedUserId(userId);
            //启动流程
            ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("xqd");
            return processInstance;
        }else {
            return processInstance;
        }
    }
}
