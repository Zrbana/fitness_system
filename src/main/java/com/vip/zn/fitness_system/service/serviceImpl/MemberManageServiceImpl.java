package com.vip.zn.fitness_system.service.serviceImpl;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.db.mapper.UserMapper;
import com.vip.zn.fitness_system.db.service.impl.AccountServiceImpl;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.paramsValidator.RequestValidator;
import com.vip.zn.fitness_system.service.MemberManageService;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/17 12:01
 */

@Slf4j
@Service
public class MemberManageServiceImpl implements MemberManageService {

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    UserMapper userMapper;

    @Override
    public void login(Account account) {

    }

    @Override
    public void enroll(Account account) {

    }

    @Override
    public WebResult addUser(AddUserInfoReq user) {
        RequestValidator.addUserRequestInfoValidator(user);
        try {
           return doAddUserInfo(user);
        } catch (Exception e) {
            log.error("新增会员信息失败", e);
            return WebResult.buildFail("新增会员信息失败，失败信息：" + e.getMessage());
        }
    }

    @Override
    public User updateUserInfo(@Validated User user) {
        //TODO
        return null;
    }

    @Override
    public User getUserByName(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new Exception(String.valueOf(WebResult.buildFail("查询条件为空", "-1")));
        }
        // return userService.getOne(new QueryWrapper<User>().eq("name", name));
        return null;
    }

    @Override
    public User getUserByPhoneNum(String phoneNum) {
//        return userService.getOne(new QueryWrapper<User>().eq("phoneNumber", phoneNum));
        return null;
    }


    @Override
    public User getUserByCardNum(String cardNum) {
        return null;
    }

    public WebResult doAddUserInfo(AddUserInfoReq req) {
        /**
         * 1.根据卡类型生成有效期限，卡号前缀是卡类型名称简写
         */
        User user = new User();
        //年卡
        if (req.getCardType().equals(CardTypeEnum.YEAR_CARD)) {
            user.setCardType(req.getCardType().getCardType());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("nk"));
            user.setBeginTime(LocalDate.now());
            user.setEndTime(LocalDate.now().plusYears(1L));
        }//季卡
        else if (req.getCardType().equals(CardTypeEnum.SEASON_CARD)) {
            user.setCardType(req.getCardType().getCardType());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("jk"));
            user.setBeginTime(LocalDate.now());
            user.setEndTime(LocalDate.now().plusMonths(3L));
        }//月卡
        else if (req.getCardType().equals(CardTypeEnum.MONTH_CARD)) {
            user.setCardType(req.getCardType().getCardType());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("yk"));
            user.setBeginTime(LocalDate.now());
            user.setEndTime(LocalDate.now().plusMonths(1L));
        }//周卡
        else if (req.getCardType().equals(CardTypeEnum.WEEK_CARD)) {
            user.setCardType(req.getCardType().getCardType());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("zk"));
            user.setBeginTime(LocalDate.now());
            user.setEndTime(LocalDate.now().plusWeeks(1L));
        }
        user.setIsExpired(0);
        user.setGender(req.getGender());
        user.setName(req.getName());
        user.setPhoneNumber(req.getPhoneNumber());
        //校验落库的user信息是否完整

        /**
         * 2.如果当前时间大于卡可用结束时间，is_expired置为1 TODO
         */
        try {
            userMapper.insert(user);
        } catch (Exception ex) {
            throw  new BizException("新增会员信息插入数据库失败");
        }
        return WebResult.buildSucc("新增会员信息成功", "200", user);
    }

}











