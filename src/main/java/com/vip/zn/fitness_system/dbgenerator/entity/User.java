package com.vip.zn.fitness_system.dbgenerator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author na.zhao
 * @since 2021-04-27
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
    private String name;

    /**
     * 性别 女1  男2
     */
    private Integer gender;

    /**
     * 开始使用时间
     */
    private LocalDate beginTime;

    /**
     * 结束使用时间
     */
    private LocalDate endTime;

    /**
     * 卡类型 0年卡 1季卡 2月卡
     */
    private Integer cardType;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 卡号
     */
    private String cardNum;

    /**
     * 是否过期 0未过期 1已过期
     */
    private Integer isExpired;


}
