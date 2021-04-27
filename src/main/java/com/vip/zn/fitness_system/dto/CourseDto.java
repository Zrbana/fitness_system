package com.vip.zn.fitness_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName CourseDto
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:13
 */

@Data
public class CourseDto {
    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程开始时间
     */
    private LocalDateTime courseBeginTime;

    /**
     * 课程结束时间
     */
    private LocalDateTime courseEndTime;

    /**
     * 私教id
     */
    private String teacherId;

    /**
     * 私教姓名
     */
    private String teacherName;
}
