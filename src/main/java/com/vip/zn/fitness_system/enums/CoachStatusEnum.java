package com.vip.zn.fitness_system.enums;

/**
 * @ClassName TeacherStatusEnum
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 20:03
 */


public enum  CoachStatusEnum {
    LEAVE(-1, "离职"),
    WORK(0, "正常"),;

    private Integer statusCode;
    private String statusName;


    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    CoachStatusEnum(Integer statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }
}
