package com.vip.zn.fitness_system.db.mapper;

import com.vip.zn.fitness_system.db.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByName(String name);

    List<User> selectByPhone(String name);

    List<User> selectByCardNum(String name);

    int insertOrUpdate(User user);
}