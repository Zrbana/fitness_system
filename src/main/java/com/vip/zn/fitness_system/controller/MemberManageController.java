package com.vip.zn.fitness_system.controller;

import cn.hutool.system.UserInfo;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.UserDto;
import com.vip.zn.fitness_system.dto.dtoMapper.DtoAndEntityConvertor;
import com.vip.zn.fitness_system.service.MemberManageService;
import com.vip.zn.fitness_system.service.serviceImpl.MemberManageServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName MemberManageController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 17:38
 */

@RestController
@RequestMapping(value = "/member")
@Api("会员管理接口")
public class MemberManageController {

    @Autowired
    MemberManageService memberManageService;

    @ApiOperation("新增会员信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public WebResult addUserInfo(@RequestBody AddUserInfoReq req) {
        return memberManageService.addUser(req);
    }

    @ApiOperation("修改会员信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResult updateUserInfo(UserDto user) {
        try {
            memberManageService.updateUserInfo(DtoAndEntityConvertor.INSTANCE.Dto2UserEntity(user));
        } catch (Exception e) {
            return WebResult.buildFail("修改会员信息失败，请联系系统管理员！", "-1");
        }
        return WebResult.buildSucc("修改会员信息成功！", "200", user);
    }

    @ApiOperation("根据姓名查询会员详细信息")
    @RequestMapping(value = "/getInfoByName", method = RequestMethod.POST)
    public WebResult getUserInfoByName(String name) {
        if (name == null || StringUtils.isBlank(name)) {
            WebResult.buildFail("姓名不允许为空！", "-1");
        }
        try {
            memberManageService.getUserByName(name);
        } catch (Exception e) {
            return WebResult.buildFail("查询失败，请联系系统管理员！", "-1");
        }
        return WebResult.buildSucc("查询成功", "200");
    }

    @ApiOperation("根据电话号码查询会员详细信息")
    @RequestMapping(value = "/getInfoByPhone", method = RequestMethod.POST)
    public WebResult getUserInfoByPhoneNum(String phoneNumber) {
        if (phoneNumber == null || StringUtils.isBlank(phoneNumber)) {
            WebResult.buildFail("电话号码不允许为空！", "-1");
        }
        try {
            memberManageService.getUserByPhoneNum(phoneNumber);
        } catch (Exception e) {
            return WebResult.buildFail("查询失败，请联系系统管理员！", "-1");
        }
        return WebResult.buildSucc("查询成功", "200");
    }
}
