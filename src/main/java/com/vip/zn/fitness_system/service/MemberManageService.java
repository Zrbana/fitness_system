package com.vip.zn.fitness_system.service;


import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AccountDto;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.UserDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface MemberManageService {

    /**
     * 登录
     */
    WebResult login(AccountDto accountDto, HttpServletResponse response);

    /**
     * 注册
     */
    WebResult enroll(AccountDto accountDto);

    /**
     * 新增会员信息
     */
    WebResult addUser(AddUserInfoReq req);

    /**
     * 更新会员信息
     */
    WebResult updateUserInfo(UserDto userDto);

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
