package com.vip.zn.fitness_system.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.db.mapper.UserMapper;
import com.vip.zn.fitness_system.db.service.impl.AccountServiceImpl;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByNameReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByPhoneNumReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByCardNumReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.paramsValidator.RequestValidator;
import com.vip.zn.fitness_system.service.MemberManageService;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public WebResult addUser(AddUserInfoReq req) {
        RequestValidator.addUserRequestInfoValidator(req);
        try {
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

            userMapper.insert(user);
            /**
             * 2.如果当前时间大于卡可用结束时间，is_expired置为1 TODO
             */
            return WebResult.buildSucc("新增会员信息成功", "200", user);
        } catch (BizException e) {
            log.error("新增会员信息失败", e);
            return WebResult.buildFail("新增会员信息失败，失败信息：" + e.getMessage());
        }
    }

    @Override
    //TODO
    public WebResult updateUserInfo(GetUserInfoByPhoneNumReq req) {
        userMapper.update(new User(),new UpdateWrapper<User>().setSql("update user set  "));
        return WebResult.buildSucc("更新成功");
    }


    @Override
    public WebResult getUserByName(GetUserInfoByNameReq req) {
        if(StringUtils.isBlank(req.getName())){
            return WebResult.buildFail("查询条件为空");
        }
        List<User> queryResult;
        try {
          queryResult = userMapper.selectList(new QueryWrapper<User>().like("name", req.getName()));
        }catch (BizException e){
            return WebResult.buildFail("查询失败，失败信息："+e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功","200",queryResult);
    }


    @Override
    public WebResult getUserByPhoneNum(GetUserInfoByPhoneNumReq req) {
        if(StringUtils.isBlank(req.getPhoneNumber())){
            return WebResult.buildFail("查询条件为空");
        }
        List<User> queryResult;
        try {
            queryResult = userMapper.selectList(new QueryWrapper<User>().eq("phone_number", req.getPhoneNumber()));
        }catch (BizException e){
            return WebResult.buildFail("查询失败，失败信息："+e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功","200",queryResult);
    }


    @Override
    public WebResult getUserByCardNum(GetUserInfoByCardNumReq req) {
        if(StringUtils.isBlank(req.getCardNum())){
            return WebResult.buildFail("查询条件为空");
        }
        List<User> queryResult;
        try {
            queryResult = userMapper.selectList(new QueryWrapper<User>().like("card_num", req.getCardNum()));
        }catch (BizException e){
            return WebResult.buildFail("查询失败，失败信息："+e.getErrorMsg());
        }
        return WebResult.buildSucc("查询成功","200",queryResult);
    }

}











