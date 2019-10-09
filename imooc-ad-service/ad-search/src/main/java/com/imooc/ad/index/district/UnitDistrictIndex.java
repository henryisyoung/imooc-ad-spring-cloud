package com.imooc.ad.index.district;

import com.imooc.ad.index.IndexAware;
import com.imooc.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Component
public class UnitDistrictIndex implements IndexAware<String, Set<Long>> {

    private static Map<String, Set<Long>> disUnitMap;

    private static Map<Long, Set<String>> unitDisMap;

    static {
        disUnitMap = new ConcurrentHashMap<>();
        unitDisMap = new ConcurrentHashMap<>();
    }
    @Override
    public Set<Long> get(String key) {
        return disUnitMap.get(key);
    }

    @Override
    public void add(String key, Set<Long> value) {
        log.info("UnitDistrictIndex before add: {}", unitDisMap);

        Set<Long> unitIdSet = CommonUtils.getOrCreate(key, disUnitMap, ConcurrentSkipListSet::new);
        unitIdSet.addAll(value);

        for (Long unitId : value) {
            Set<String> dis = CommonUtils.getOrCreate(unitId, unitDisMap, ConcurrentSkipListSet::new);
            dis.add(key);
        }

        log.info("UnitDistrictIndex after add: {}", unitDisMap);
    }

    @Override
    public void update(String key, Set<Long> value) {
        log.error("district index cannot support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        log.info("UnitDistrictIndex before delete: {}", unitDisMap);

        Set<Long> unitIds = CommonUtils.getOrCreate(
                key, disUnitMap, ConcurrentSkipListSet::new
        );
        unitIds.removeAll(value);
        for (Long unitId : value) {
            Set<String> dis = CommonUtils.getOrCreate(unitId, unitDisMap, ConcurrentSkipListSet::new);
            dis.remove(key);
        }

        log.info("UnitDistrictIndex after delete : {}", unitDisMap);
    }

    public boolean match(Long unitId, List<String> keywords) {
        if (unitDisMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitDisMap.get(unitId))) {
            Set<String> unitKeywords = unitDisMap.get(unitId);
            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }
        return false;
    }
}
