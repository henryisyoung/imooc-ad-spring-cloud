package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUser;
import com.imooc.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCreativeRepository extends JpaRepository<Creative, Long> {
}
