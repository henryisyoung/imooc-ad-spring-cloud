package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.annotation.IgnoreReponseAdvice;
import com.imooc.ad.client.SponsorClient;
import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.client.vo.AdPlanGetRequest;
import com.imooc.ad.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class SearchController {
    private final RestTemplate restTemplate;
    private final SponsorClient client;
    public SearchController(RestTemplate restTemplate, SponsorClient client) {
        this.restTemplate = restTemplate;
        this.client = client;
    }

    @IgnoreReponseAdvice
    @RequestMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request){
        log.info("ad-search: getAdPlans -> {}", JSON.toJSONString(request) );
        return client.getAdPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreReponseAdvice
    @PostMapping("/getAdPlansByRebbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRebbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlansByRebbon -> {}", JSON.toJSONString(request) );
        return restTemplate.postForEntity("http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class).getBody();
    }
}
