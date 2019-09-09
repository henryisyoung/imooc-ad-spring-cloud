package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit")
public class AdUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "plan_id", nullable = false)
    private Long planId;

    @Column(name = "unit_name", nullable = false)
    private String unitName;

    @Column(name = "unit_status", nullable = false)
    private Integer unitStatus;

    @Column(name = "position_type", nullable = false)
    private Integer positionType;

    @Column(name = "budget", nullable = false)
    private Long budget;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUnit(Long planId, String unitName, Integer positionType, Long budget) {
        this.budget = budget;
        this.planId = planId;
        this.unitName = unitName;
        this.positionType = positionType;
        this.unitStatus = CommonStatus.VALID.getStatus();
        createTime = new Date();
        updateTime = createTime;
    }
}
