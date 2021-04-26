package com.vip.zn.fitness_system.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author na.zhao
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不允许为空")
    private String name;

    /**
     * 性别 女1  男2
     */
    @NotBlank(message = "性别不允许为空")
    private Integer gender;

    /**
     * 开始使用时间
     */
    @NotBlank(message = "开始时间不允许为空")
    private LocalDate beginTime;

    /**
     * 结束使用时间
     */
    @NotBlank(message = "结束时间不允许为空")
    private LocalDate endTime;

    /**
     * 卡类型 0年卡 1季卡 2月卡 3周卡
     */
    @NotBlank(message = "卡类型不允许为空")
    private Integer cardType;

    /**
     * 手机号码
     */
    @NotBlank(message = "电话号码不允许为空")
    private String phoneNumber;

    /**
     * 卡号
     */
    @NotBlank(message = "卡号不允许为空")
    private String cardNum;

    /**
     * 是否过期 0未过期 1已过期
     */
    @NotBlank(message = "是否过期字段不允许为空")
    private Integer isExpired;


}
