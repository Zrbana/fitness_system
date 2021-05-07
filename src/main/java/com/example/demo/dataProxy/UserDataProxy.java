package com.example.demo.dataProxy;

import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.utils.FitnessDefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.util.MD5Utils;

import java.time.LocalDate;

/**
 * @ClassName UserDataProxy
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 15:59
 */

@Service
public class UserDataProxy implements DataProxy<User> {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void beforeAdd(User user) {
        user.setIsExpired(true);
        //根据卡类型生成激活开始时间和结束时间 and 卡号
        if (("年卡").equals(user.getCardType())) {
            user.setBeginTime(LocalDate.now().toString());
            user.setEndTime(LocalDate.now().plusYears(1L).toString());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("nk"));
        } else if (("季卡").equals(user.getCardType())) {
            user.setBeginTime(LocalDate.now().toString());
            user.setEndTime(LocalDate.now().plusMonths(3L).toString());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("jk"));
        } else if (("月卡").equals(user.getCardType())) {
            user.setBeginTime(LocalDate.now().toString());
            user.setEndTime(LocalDate.now().plusMonths(1L).toString());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("yk"));
        } else if (("周卡").equals(user.getCardType())) {
            user.setBeginTime(LocalDate.now().toString());
            user.setEndTime(LocalDate.now().plusWeeks(1L).toString());
            user.setCardNum(FitnessDefaultUtils.randomCardNum("zk"));
        } else {
            throw new EruptApiErrorTip("卡类型只支持：年卡/季卡/月卡/周卡");
        }
    }

    @Override
    public void afterAdd(User user) {
        //如果当前时间小于结束时间，则已过期
//        if (LocalDate.now().compareTo(user.getEndTime()) > 0) {
//            user.setIsExpired("已过期");
//        } else {
//            user.setIsExpired("可用状态");
//        }
        //新增用户后，为用户创建账号，可进行预约课程的操作
        //账户名：卡号  默认密码：123456
        EruptUser newAccount = new EruptUser();
        newAccount.setAccount(user.getCardNum());
        String pwd = MD5Utils.digest("123456");
        newAccount.setPassword(pwd);
        accountRepository.save(newAccount);
    }
}

