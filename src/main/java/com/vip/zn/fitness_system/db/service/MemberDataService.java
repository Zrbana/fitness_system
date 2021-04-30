package com.vip.zn.fitness_system.db.service;

import com.vip.zn.fitness_system.db.model.User;

import java.util.List;

public interface MemberDataService {
    int insertSelective(User user);

    int updateSelective(User user);

    List<User> selectByName(String name);

    List<User> selectByPhone(String phoneNum);

    List<User> selectByCardNum(String cardNum);

    User selectById(Integer id);
}
