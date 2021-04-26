package com.vip.zn.fitness_system.service;


import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByNameReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByPhoneNumReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByCardNumReq;

public interface MemberManageService {

    /** 登录 */
    void login(Account account);

    /** 注册 */
    void enroll(Account account);

    /** 新增会员信息 */
    WebResult addUser(AddUserInfoReq req);

    /** 更新会员信息 */
    WebResult updateUserInfo(GetUserInfoByPhoneNumReq req);

    /** 根据姓名模糊查询用户信息 */
    WebResult getUserByName(GetUserInfoByNameReq req);

    /** 根据电话号码精确查询用户信息 */
    WebResult getUserByPhoneNum(GetUserInfoByPhoneNumReq req);

    /** 根据卡号模糊查询用户信息 */
    WebResult getUserByCardNum(GetUserInfoByCardNumReq req);


}
