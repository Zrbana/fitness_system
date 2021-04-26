package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.db.mapper.AccountMapper;
import com.vip.zn.fitness_system.db.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author na.zhao
 * @since 2021-04-21
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
