package com.yfny.servicepojo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 需求单流程记录表实例
 * <p>
 * Created  by  jinboYu  on  2019/3/7
 */
@Table(name = "record")
public class RecordEntity implements Serializable {

    @Id
    private Long id;//主键ID

    @Column(name = "DEMAND_ID")
    private Long demandId;//需求单ID

    @Column(name = "AUDITOR_ID")
    private String auditorId;//审核人ID

    @Column(name = "AUDITOR_OPINION")
    private String auditorOpinion;//审核意见

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorOpinion() {
        return auditorOpinion;
    }

    public void setAuditorOpinion(String auditorOpinion) {
        this.auditorOpinion = auditorOpinion;
    }

    public RecordEntity() {
    }

    public RecordEntity(Long id, Long demandId, String auditorId, String auditorOpinion) {
        this.id = id;
        this.demandId = demandId;
        this.auditorId = auditorId;
        this.auditorOpinion = auditorOpinion;
    }
}
