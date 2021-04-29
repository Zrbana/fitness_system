package com.vip.zn.fitness_system.enums;

public enum GenderTypeEnum {
    MAN((byte)-1, "男性"),
    WOMAN((byte)0, "女性"),;

    private Byte genderCode;
    private String genderName;


    public Byte getGenderCode() {
        return genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    GenderTypeEnum(Byte genderCode, String genderName) {
        this.genderCode = genderCode;
        this.genderName = genderName;
    }
}
