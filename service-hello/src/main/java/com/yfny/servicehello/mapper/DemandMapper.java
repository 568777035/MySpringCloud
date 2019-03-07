package com.yfny.servicehello.mapper;

import com.yfny.servicepojo.entity.DemandEntity;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 需求单Mapper
 * <p>
 * Created  by  jinboYu  on  2019/3/6
 */
public interface DemandMapper extends BaseMapper<DemandEntity> {

    @Insert("INSERT demand SET CREATEBY_ID = #{createById},CREATEBY_NAME = #{createByName},DEMAND_NAME = #{demandName},DEMAND_STATUS = #{demandStatus},DEMAND_DESCRIPTION = #{demandDescription},ORG_ID = #{orgId}")
    int submitDemand(String createById,String createByName,String demandName,String demandStatus,String demandDescription,String orgId);
}
