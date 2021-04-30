package com.vip.zn.fitness_system.dto;

import cn.hutool.core.date.DateTime;
import lombok.Data;


/**
 * @ClassName AddCourseReq
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/30 13:23
 */

@Data
public class AddCourseReq {
    private String courseName;

    private DateTime courseBeginTime;

    private DateTime courseEndTime;

    private String coachName;
}
