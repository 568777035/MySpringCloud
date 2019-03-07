package com.yfny.servicefeign.controller;

import com.yfny.servicefeign.service.ExampleActivitiApiService;
import com.yfny.servicefeign.service.ExampleHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/submitDemand")
    public String submitDemand(@RequestParam String createById,@RequestParam String createByName, @RequestParam String demandName, @RequestParam String demandStatus, @RequestParam String demandDescription, @RequestParam String orgId){
        int i = exampleActivitiApiService.submitDemand(createById,createByName,orgId,demandDescription);
        if (i==1){
            switch (orgId){
                case "1":
                    demandStatus="网级审核中";
                    break;
                case "2":
                    demandStatus="省级审核中";
                    break;
                case "3":
                    demandStatus="地级审核中";
                    break;
            }
            int j = exampleHelloService.submitDemand(createById,createByName,demandName,demandStatus,demandDescription,orgId);
            if (j==1){
                return "需求单提交成功！！";
            }else {
                return "需求单提交失败！！";
            }
        }else {
            return "需求单提交失败，创建流程失败！！";
        }
    }
}
