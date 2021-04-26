package com.vip.zn.fitness_system.paramsValidator;

import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.utils.CheckUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName AddUserInfoReqValidator
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 20:23
 */


public class RequestValidator {

    public static void addUserRequestInfoValidator(AddUserInfoReq req) {
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getName()), "会员姓名不能为空");
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getPhoneNumber()), "会员联系方式不能为空");
        CheckUtils.assertTrue(req != null && !req.getCardType().equals(CardTypeEnum.values()), "不存在的会员卡类型");
        CheckUtils.assertTrue(req != null && !req.getGender().equals(CardTypeEnum.values()), "不允许的会员卡类型");
    }

    public static void insertIntoTableUserValidator(User user){
        CheckUtils.assertTrue(StringUtils.isNoneBlank(user.getName()),"会员姓名不能为空");
        CheckUtils.assertTrue(StringUtils.isNoneBlank(user.getPhoneNumber()),"会员联系方式不能为空");
    }
}
