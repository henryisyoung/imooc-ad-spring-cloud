package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {
    AdUnit findByPlanIdAAndUnitName(Long planId, String unitName);

    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
