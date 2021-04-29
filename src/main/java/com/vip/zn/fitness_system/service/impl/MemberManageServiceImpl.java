package com.vip.zn.fitness_system.service.impl;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.model.Account;
import com.vip.zn.fitness_system.db.model.User;
import com.vip.zn.fitness_system.db.service.MemberDataService;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByPhoneNumReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.paramsValidator.RequestValidator;
import com.vip.zn.fitness_system.service.MemberManageService;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Override
    public void login(Account account) {

    }

    @Override
    public void enroll(Account account) {

    }

    @Override
    public WebResult addUser(AddUserInfoReq req) {
        RequestValidator.addUserRequestInfoValidator(req);
        User userInfo = new User();
        userInfo.setName(req.getName());
        userInfo.setPhoneNumber(req.getPhoneNumber());
        userInfo.setIsExpired((byte) 0);
        userInfo.setGender(req.getGender());
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
            memberDataService.insertSelective(userInfo);
        } catch (BizException e) {
            return WebResult.buildFail("新增会员信息失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("新增会员信息成功");
    }

    @Override
    public WebResult updateUserInfo(GetUserInfoByPhoneNumReq req) {
        return null;
    }

    @Override
    public WebResult getUserByName(String name) {
        if (StringUtils.isBlank(name)) {
            return WebResult.buildFail("查询条件为空");
        }
        try {
            memberDataService.selectByName(name);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功");
    }

    @Override
    public WebResult getUserByPhoneNum(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return WebResult.buildFail("查询条件为空");
        }
        try {
            memberDataService.selectByPhone(phoneNumber);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功");
    }

    @Override
    public WebResult getUserByCardNum(String cardNumber) {
        if (StringUtils.isBlank(cardNumber)) {
            return WebResult.buildFail("查询条件为空");
        }
        try {
            memberDataService.selectByCardNum(cardNumber);
        } catch (BizException e) {
            return WebResult.buildFail("查询失败", e.getMessage());
        }
        return WebResult.buildSucc("查询成功");
    }
}
