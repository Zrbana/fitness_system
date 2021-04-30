package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.JwtUtils;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.service.AccountDataService;
import com.vip.zn.fitness_system.dto.AccountDto;
import com.vip.zn.fitness_system.service.MemberManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/17 10:57
 */

@RestController
@RequestMapping(value = "/account")
@Api("账户管理接口")
public class AccountManageController {

    @Autowired
    AccountDataService accountDataService;

    @Autowired
    MemberManageService memberManageService;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("登录")
    @ResponseBody
    public WebResult login(@Validated @RequestBody AccountDto accountDto, HttpServletResponse response) {
        return memberManageService.login(accountDto,response);
    }

    @ApiOperation("登出")
    @RequiresAuthentication
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public WebResult logout() {
        SecurityUtils.getSubject().logout();
        return WebResult.buildSucc(null);
    }
}















