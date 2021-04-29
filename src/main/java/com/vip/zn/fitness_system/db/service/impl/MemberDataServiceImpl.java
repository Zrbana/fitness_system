package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.mapper.UserMapper;
import com.vip.zn.fitness_system.db.model.User;
import com.vip.zn.fitness_system.db.service.MemberDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MemberService
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 15:03
 */

@Service
public class MemberDataServiceImpl implements MemberDataService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateSelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<User> selectByPhone(String phoneNum) {
        return userMapper.selectByPhone(phoneNum);
    }

    @Override
    public List<User> selectByCardNum(String cardNum) {
        return userMapper.selectByCardNum(cardNum);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
