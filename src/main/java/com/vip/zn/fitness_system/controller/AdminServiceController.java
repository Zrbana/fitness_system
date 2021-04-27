package com.vip.zn.fitness_system.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vip.zn.fitness_system.common.JwtUtils;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dbgenerator.entity.Account;
import com.vip.zn.fitness_system.dbgenerator.service.impl.AccountServiceImpl;
import com.vip.zn.fitness_system.dto.LoginDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
public class AdminServiceController {

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("登录")
    public WebResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        Account account = accountService.getOne(new QueryWrapper<Account>().eq("username", loginDto.getUserName()));
        Assert.notNull(account, "用户不存在");

        if (!account.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return WebResult.buildFail("密码不正确", "-1");
        }
        String jwt = jwtUtils.generateToken(account.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return WebResult.buildSucc(
                MapUtil.builder()
                        .put("id", account.getId())
                        .put("username", account.getUsername())
                        .map()
        );
    }

    @ApiOperation("登出")
    @RequiresAuthentication
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public WebResult logout() {
        SecurityUtils.getSubject().logout();
        return WebResult.buildSucc(null);
    }
}















