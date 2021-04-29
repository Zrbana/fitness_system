package com.vip.zn.fitness_system.enums;


/**
 * @ClassName CardTypeEnum
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 20:52
 */

public enum CardTypeEnum {
    YEAR_CARD((byte)0, "年卡"),
    SEASON_CARD((byte)1, "季卡"),
    MONTH_CARD((byte)2, "月卡"),
    WEEK_CARD((byte)3, "周卡");

    private Byte cardCode;
    private String cardName;


    public Byte getCardCode() {
        return cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    CardTypeEnum(Byte cardType, String cardName) {
        this.cardCode = cardType;
        this.cardName = cardName;
    }
}
