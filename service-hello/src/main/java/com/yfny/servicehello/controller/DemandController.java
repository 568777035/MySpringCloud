package com.yfny.servicehello.controller;

import com.yfny.servicehello.service.DemandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Created  by  jinboYu  on  2019/3/6
 */
@RestController
@RequestMapping(value = "/demand")
public class DemandController {

    @Autowired
    private DemandServiceImpl demandService;

    @GetMapping("/submitDemand")
    public int submitDemand(@RequestParam String createById,@RequestParam String createByName,@RequestParam String demandName,@RequestParam String demandDescription,@RequestParam String orgId){
        return demandService.submitDemand(createById,createByName,demandName,demandDescription,orgId);
    }
}
