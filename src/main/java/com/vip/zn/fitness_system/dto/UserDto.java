package com.vip.zn.fitness_system.dto;

import com.vip.zn.fitness_system.enums.CardTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @ClassName AddUserDto
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/17 11:59
 */

@Data
public class UserDto {
    @NotBlank(message = "姓名不允许为空")
    private String name;

    @NotBlank(message = "性别不允许为空")
    private Integer gender;

    private LocalDate beginTime;

    private LocalDate endTime;

    @NotBlank(message = "卡类型不允许为空")
    private CardTypeEnum cardType;

    @NotBlank(message = "电话号码不允许为空")
    private String phoneNumber;

    private String cardNum;

    private Integer isExpired;
}
