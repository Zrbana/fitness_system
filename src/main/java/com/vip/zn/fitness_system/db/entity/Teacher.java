package com.vip.zn.fitness_system.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 私教id
     */
    @TableField("teacherId")
    private String teacherId;

    /**
     * 私教姓名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 私教电话
     */
    private String phoneNumber;

    /**
     * 在职情况 0离职 1正常
     */
    private Integer status;


}
