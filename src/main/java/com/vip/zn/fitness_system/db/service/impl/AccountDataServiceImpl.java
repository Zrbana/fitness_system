package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.mapper.AccountMapper;
import com.vip.zn.fitness_system.db.model.Account;
import com.vip.zn.fitness_system.db.service.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountDataServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 22:07
 */

@Service
public class AccountDataServiceImpl implements AccountDataService{

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account selectByUserName(String userName) {
        return accountMapper.selectByUserName(userName);
    }

    @Override
    public int insertSelective(Account account) {
        return accountMapper.insertSelective(account);
    }
}
