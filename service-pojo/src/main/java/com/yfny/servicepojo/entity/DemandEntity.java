package com.yfny.servicepojo.entity;

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
    @Column(name = "ID")
    private Long id;//主键ID

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

    @Column(name = "TASK_ID")
    private String taskId;//流程实例ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandDescription() {
        return demandDescription;
    }

    public void setDemandDescription(String demandDescription) {
        this.demandDescription = demandDescription;
    }

    public String getDemandStatus() {
        return demandStatus;
    }

    public void setDemandStatus(String demandStatus) {
        this.demandStatus = demandStatus;
    }

    public String getAduitorId() {
        return aduitorId;
    }

    public void setAduitorId(String aduitorId) {
        this.aduitorId = aduitorId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public DemandEntity() {
    }

    public DemandEntity(Long id, String createByName, String demandName, String demandDescription, String demandStatus, String aduitorId, String orgId, Date startTime, Date endTime, String createById, String taskId) {
        this.id = id;
        this.createByName = createByName;
        this.demandName = demandName;
        this.demandDescription = demandDescription;
        this.demandStatus = demandStatus;
        this.aduitorId = aduitorId;
        this.orgId = orgId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createById = createById;
        this.taskId = taskId;
    }
}
