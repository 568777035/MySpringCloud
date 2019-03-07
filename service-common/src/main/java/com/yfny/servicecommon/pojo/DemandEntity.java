package com.yfny.servicecommon.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 需求单实例对象
 * <p>
 * Created  by  jinboYu  on  2019/3/6
 */
@Table(name = "demand")
public class DemandEntity implements Serializable {

    @Id
    private int id;//主键ID

    @Column(name = "CREATEBY_NAME")
    private String createByName;//创建人名称

    @Column(name = "DEMAND_NAME")
    private String demandName;//需求单名称

    @Column(name = "DEMAND_DESCRIPTION")
    private String demandDescription;//需求单描述

    @Column(name = "DEMAND_STATUS")
    private String demandStatus;//需求单状态

    @Column(name = "AUDITOR_ID")
    private String aduitorId;//审核人ID

    @Column(name = "ORG_ID")
    private String orgId;//组织ID

    @Column(name = "STARTTIME")
    private Date startTime;//开始时间

    @Column(name = "ENDTIME")
    private Date endTime;//结束时间

    @Column(name = "CREATEBY_ID")
    private String createById;//创建人ID
}
