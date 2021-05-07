package com.example.demo.repository;

import com.example.demo.entity.Coach;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

/**
 * @ClassName
 * 直接继承 JpaRepository 就有了增删改查等能力，该功能由 spring-data-jpa 提供
 *  泛型说明：Coach 实体类对象  BigInteger 主键数据类型
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 19:09
 */


public interface CoachRepository extends Repository<Coach, BigInteger> {
    @Query("from Coach where coachName = ?1")
    Coach findByName(String name);
}