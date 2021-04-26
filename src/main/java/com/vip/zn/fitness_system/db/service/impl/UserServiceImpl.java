package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.db.mapper.UserMapper;
import com.vip.zn.fitness_system.db.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
