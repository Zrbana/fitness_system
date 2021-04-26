package com.vip.zn.fitness_system.service;


import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;

public interface MemberManageService {

    /**
     * 登录
     * @param account
     */
    void login(Account account);

    /**
     * 注册
     * @param account
     */
    void enroll(Account account);

    /** 新增会员信息 */
    WebResult addUser(AddUserInfoReq req);

    /**
     * 修改会员信息
     * @param user
     * @return
     */
    User updateUserInfo(User user);

    /**
     * 根据姓名查询用户信息
     * @return
     */
    User getUserByName(String name) throws Exception;

    /**
     * 根据电话号码查询用户信息
     * @return
     */
    User getUserByPhoneNum(String phoneNum);

    /**
     * 根据卡号查询用户信息
     * @return
     */
    User getUserByCardNum(String cardNum);


}
