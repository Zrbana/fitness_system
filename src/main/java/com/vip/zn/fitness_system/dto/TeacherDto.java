package com.vip.zn.fitness_system.dto;


import lombok.Data;

/**
 * @ClassName TeacherDto
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:00
 */

@Data
public class TeacherDto {
    /**
     * 私教Id
     */
    private String teacherId;

    /**
     * 私教姓名
     */
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
