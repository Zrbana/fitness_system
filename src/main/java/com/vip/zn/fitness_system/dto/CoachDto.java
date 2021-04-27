package com.vip.zn.fitness_system.dto;


import com.vip.zn.fitness_system.enums.CoachStatusEnum;
import lombok.Data;

/**
 * @ClassName TeacherDto
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:00
 */

@Data
public class CoachDto {
    /**
     * 私教Id
     */
    private String coachId;

    /**
     * 私教姓名
     */
    private String coachName;

    /**
     * 私教电话
     */
    private String phoneNumber;

    /**
     * 在职情况 0离职 1正常
     */
    private CoachStatusEnum status;
}
