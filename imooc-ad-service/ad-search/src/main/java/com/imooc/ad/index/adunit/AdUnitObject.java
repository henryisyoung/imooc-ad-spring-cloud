package com.imooc.ad.index.adunit;

import com.imooc.ad.index.adplan.AdPlanObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitObject {

    private Long unitId;
    private Integer unitStatus;
    private Integer positionType;
    private Long planId;

    private AdPlanObject adPlanObject;

    public void update(AdUnitObject newObject) {
        if (newObject.planId != null) {
            this.planId = newObject.planId;
        }
        if (newObject.unitStatus != null) {
            this.unitStatus = newObject.unitStatus;
        }
        if (newObject.unitId != null) {
            this.unitId = newObject.unitId;
        }
        if (newObject.positionType != null) {
            this.positionType = newObject.positionType;
        }
        if (newObject.adPlanObject != null) {
            this.adPlanObject = newObject.adPlanObject;
        }
    }
}
