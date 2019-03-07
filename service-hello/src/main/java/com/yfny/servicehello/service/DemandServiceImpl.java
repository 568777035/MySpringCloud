package com.yfny.servicehello.service;

import com.yfny.servicehello.mapper.DemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单Service
 * <p>
 * Created  by  jinboYu  on  2019/3/6
 */
@Service
public class DemandServiceImpl {

    @Autowired
    private DemandMapper demandMapper;

    public int submitDemand(String createById,String createByName,String demandName,String demandStatus,String demandDescription,String orgId){
        return demandMapper.submitDemand(createById,createByName,demandName,demandStatus,demandDescription,orgId);
    }
}
