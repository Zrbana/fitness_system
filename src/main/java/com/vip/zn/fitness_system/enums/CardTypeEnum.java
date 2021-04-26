package com.vip.zn.fitness_system.enums;


/**
 * @ClassName CardTypeEnum
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 20:52
 */

public enum CardTypeEnum {
    YEAR_CARD(0, "年卡"),
    SEASON_CARD(1, "季卡"),
    MONTH_CARD(2, "月卡"),
    WEEK_CARD(3, "周卡");

    private Integer cardCode;
    private String cardName;


    public Integer getCardType() {
        return cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    CardTypeEnum(Integer cardType, String cardName) {
        this.cardCode = cardType;
        this.cardName = cardName;
    }
}
