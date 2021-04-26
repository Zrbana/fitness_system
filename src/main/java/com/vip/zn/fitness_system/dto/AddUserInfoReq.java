package com.vip.zn.fitness_system.dto;

import com.vip.zn.fitness_system.enums.CardTypeEnum;
import lombok.Data;

/**
 * @ClassName AddUserInfoReq
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 10:51
 */

@Data
public class AddUserInfoReq {
    String name;
    String phoneNumber;
    Integer gender;
    CardTypeEnum cardType;
}
