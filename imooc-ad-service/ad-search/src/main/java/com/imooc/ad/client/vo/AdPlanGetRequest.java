package com.imooc.ad.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {
    private long userId;
    private List<Long> ids;
}
