package com.vip.zn.fitness_system.db.service;

import com.vip.zn.fitness_system.db.model.User;

import java.util.List;

public interface MemberDataService {
    /**
     * 插入会员信息
     * @param user
     * @return
     */
    public int insertSelective(User user);

    /**
     * 更新会员信息
     * @param user
     * @return
     */
    public int updateSelective(User user);

    /**
     * 根据姓名查询用户列表
     * @param name
     * @return
     */
    public List<User> selectByName(String name);

    /**
     * 根据电话号码查询用户列表
     * @param phoneNum
     * @return
     */
    public List<User> selectByPhone(String phoneNum);

    /**
     * 根据卡号查询用户列表
     * @param cardNum
     * @return
     */
    public List<User> selectByCardNum(String cardNum);

    /**
     * 查看用户详细信息
     * @param id
     * @return
     */
    public User selectById(Integer id);
}
