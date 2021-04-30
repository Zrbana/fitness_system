package com.vip.zn.fitness_system.db.service;

import com.vip.zn.fitness_system.db.model.Account;

public interface AccountDataService {
    Account selectByUserName(String userName);

    int insertSelective(Account account);
}
