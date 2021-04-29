package com.vip.zn.fitness_system.service;


import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.model.Account;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByNameReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByPhoneNumReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByCardNumReq;
import org.springframework.stereotype.Service;

@Service
public interface MemberManageService {

    /**
     * 登录
     */
    void login(Account account);

    /**
     * 注册
     */
    void enroll(Account account);

    /**
     * 新增会员信息
     */
    WebResult addUser(AddUserInfoReq req);

    /**
     * 更新会员信息
     */
    WebResult updateUserInfo(GetUserInfoByPhoneNumReq req);

    /**
     * 根据姓名模糊查询用户信息列表
     */
    WebResult getUserByName(String name);

    /**
     * 根据电话号码精确查询用户信息列表
     */
    WebResult getUserByPhoneNum(String phoneNumber);

    /**
     * 根据卡号模糊查询用户信息列表
     */
    WebResult getUserByCardNum(String cardNumber);


}
