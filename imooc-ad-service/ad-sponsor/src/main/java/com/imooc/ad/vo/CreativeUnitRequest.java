package com.imooc.ad.vo;

import com.imooc.ad.constant.CommonStatus;
import com.imooc.ad.entity.Creative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitRequest {
    private List<CreativeUnitItem> unitItems;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreativeUnitItem{
        private Long creativeId;
        private Long unitId;
    }
}
