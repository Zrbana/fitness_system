package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.*;
import com.vip.zn.fitness_system.service.MemberManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public WebResult updateUserInfo(@RequestBody UserDto user) {
        return null;
    }

    @ApiOperation("根据姓名查询会员详细信息")
    @RequestMapping(value = "/getInfoByName", method = RequestMethod.POST)
    @ResponseBody
    public WebResult getUserInfoByName(@RequestBody String name) {
        return memberManageService.getUserByName(name);
    }

    @ApiOperation("根据电话号码查询会员详细信息")
    @RequestMapping(value = "/getInfoByPhone", method = RequestMethod.POST)
    @ResponseBody
    public WebResult getUserInfoByPhoneNum(@RequestBody String phoneNumber) {
        return memberManageService.getUserByPhoneNum(phoneNumber);
    }

    @ApiOperation("根据卡号模糊查询会员详细信息")
    @RequestMapping(value = "/getInfoByCardNum", method = RequestMethod.POST)
    @ResponseBody
    public WebResult getUserInfoByCardNum(@RequestBody String cardNumber) {
        return memberManageService.getUserByCardNum(cardNumber);
    }
}
