package com.vip.zn.fitness_system.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名
     */
    @TableField("courseName")
    private String courseName;

    /**
     * 课程开始时间
     */
    @TableField("courseBeginTime")
    private LocalDateTime courseBeginTime;

    /**
     * 课程结束时间
     */
    @TableField("courseEndTime")
    private LocalDateTime courseEndTime;

    /**
     * 私教id
     */
    @TableField("teacherId")
    private String teacherId;


}
