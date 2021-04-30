package com.vip.zn.fitness_system.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.vip.zn.fitness_system.common.JwtUtils;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.model.Account;
import com.vip.zn.fitness_system.db.model.User;
import com.vip.zn.fitness_system.db.service.AccountDataService;
import com.vip.zn.fitness_system.db.service.MemberDataService;
import com.vip.zn.fitness_system.dto.AccountDto;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.UserDto;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.enums.GenderTypeEnum;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.MemberManageService;
import com.vip.zn.fitness_system.utils.CheckUtils;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName MemberManageServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 19:02
 */

@Service
public class MemberManageServiceImpl implements MemberManageService {
    @Autowired
    MemberDataService memberDataService;

    @Autowired
    AccountDataService accountDataService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public WebResult login(AccountDto accountDto, HttpServletResponse response) {
        Account account = accountDataService.selectByUserName(accountDto.getUserName());
        Assert.notNull(account, "用户不存在");
        if (!account.getPassword().equals(SecureUtil.md5(accountDto.getPassword()))) {
            return WebResult.buildFail("密码不正确");
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

    @Override
    public WebResult enroll(AccountDto accountDto) {
        if (accountDto == null || StringUtils.isBlank(accountDto.getUserName()) || StringUtils.isBlank(accountDto.getPassword())) {
            return WebResult.buildFail("账号或密码不允许为空");
        }
        Account account = new Account();
        account.setUsername(accountDto.getUserName());
        account.setPassword(SecureUtil.md5(accountDto.getPassword()));
        try {
            accountDataService.insertSelective(account);
        } catch (BizException e) {
            return WebResult.buildFail("注册失败");
        }
        return WebResult.buildSucc("注册成功");
    }

    @Override
    public WebResult addOrUpdateUser(AddUserInfoReq req) {
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getName()), "会员姓名不能为空");
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getPhoneNumber()), "会员联系方式不能为空");
        CheckUtils.assertTrue(req != null && !req.getCardType().equals(CardTypeEnum.values()), "不允许的会员卡类型");
        CheckUtils.assertTrue(req != null && !req.getGender().equals(GenderTypeEnum.values()), "性别不允许为空");
        User userInfo = new User();
        userInfo.setName(req.getName());
        userInfo.setPhoneNumber(req.getPhoneNumber());
        userInfo.setIsExpired((byte) 0);
        userInfo.setGender((byte) req.getGender());
        if (req.getCardType().equals(CardTypeEnum.WEEK_CARD.getCardCode())) {
            userInfo.setCardType(req.getCardType());
            userInfo.setCardNum(FitnessDefaultUtils.randomCardNum("zk"));
            userInfo.setBeginTime(LocalDate.now());
            userInfo.setEndTime(LocalDate.now().plusWeeks(1L));
        } else if (req.getCardType().equals(CardTypeEnum.MONTH_CARD.getCardCode())) {
            userInfo.setCardType(req.getCardType());
            userInfo.setCardNum(FitnessDefaultUtils.randomCardNum("yk"));
            userInfo.setBeginTime(LocalDate.now());
            userInfo.setEndTime(LocalDate.now().plusMonths(1L));
        } else if (req.getCardType().equals(CardTypeEnum.SEASON_CARD.getCardCode())) {
            userInfo.setCardType(req.getCardType());
            userInfo.setCardNum(FitnessDefaultUtils.randomCardNum("jk"));
            userInfo.setBeginTime(LocalDate.now());
            userInfo.setEndTime(LocalDate.now().plusMonths(3L));
        } else if (req.getCardType().equals(CardTypeEnum.YEAR_CARD.getCardCode())) {
            userInfo.setCardType(req.getCardType());
            userInfo.setCardNum(FitnessDefaultUtils.randomCardNum("nk"));
            userInfo.setBeginTime(LocalDate.now());
            userInfo.setEndTime(LocalDate.now().plusYears(1L));
        }
        try {
            memberDataService.insertOrUpdate(userInfo);
        } catch (BizException e) {
            return WebResult.buildFail("新增会员信息失败", e.getErrorMsg());
        } catch (MyBatisSystemException exception) {
            return WebResult.buildFail("数据库连接异常", exception.getMessage());
        }
        return WebResult.buildSucc("新增会员信息成功", "200", userInfo);
    }

    @Override
    public WebResult updateUserInfo(UserDto userDto) {
        return null;
    }

    @Override
    public WebResult getUserByName(String name) {
        if (StringUtils.isBlank(name)) {
            return WebResult.buildFail("查询条件为空");
        }
        List<User> resultList;
        try {
            resultList = memberDataService.selectByName(name);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功", "200", resultList);
    }

    @Override
    public WebResult getUserByPhoneNum(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return WebResult.buildFail("查询条件为空");
        }
        List<User> resultList;
        try {
            resultList = memberDataService.selectByPhone(phoneNumber);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功", "200", resultList);
    }

    @Override
    public WebResult getUserByCardNum(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return WebResult.buildFail("查询条件为空");
        }
        List<User> resultList;
        try {
            resultList = memberDataService.selectByCardNum(cardNumber);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getMessage());
        }
        return WebResult.buildSucc("查询成功", "200", resultList);
    }
}
