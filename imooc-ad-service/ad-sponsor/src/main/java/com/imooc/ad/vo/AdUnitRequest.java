package com.imooc.ad.vo;

import com.netflix.discovery.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitRequest {

    private Long planId;
    private String unitName;

    private Integer postionType;
    private Long budget;

    public boolean createValidate() {
        return planId != null && !StringUtils.isEmpty(unitName) && postionType != null && budget != null;
    }
}
