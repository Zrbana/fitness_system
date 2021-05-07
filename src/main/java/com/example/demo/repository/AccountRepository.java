package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.erupt.upms.model.EruptUser;

import java.math.BigInteger;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 8:33
 */

@Repository
public interface AccountRepository extends CrudRepository<EruptUser, BigInteger> {
}
