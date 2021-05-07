package com.example.demo.entity;

import com.example.demo.dataProxy.UserDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @ClassName User
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 15:39
 */

@Data
@Erupt(name = "会员信息表",
        power = @Power(add = true, delete = false,
                edit = true, query = true,
                importable = true, export = true, viewDetails = true),
        dataProxy = UserDataProxy.class,
        orderBy = "id desc"
)
@Entity
public class User extends BaseModel {
    @EruptField(
            views = @View(title = "会员姓名"),
            edit = @Edit(title = "会员姓名", notNull = true, search = @Search(vague = true))
    )
    private String memberName;

    @EruptField(
            views = @View(title = "性别"),
            edit = @Edit(title = "性别", notNull = true, type = EditType.CHOICE, choiceType = @ChoiceType(
                    vl = {
                            @VL(label = "男", value = "男"),
                            @VL(label = "女", value = "女")
                    }
            ))
    )
    private String gender;

    @EruptField(
            views = @View(title = "卡激活时间"),
            edit = @Edit(title = "卡激活时间", notNull = false, show = false, readOnly = true)
    )
    private String beginTime;

    @Lob
    @EruptField(
            views = @View(title = "卡失效时间"),
            edit = @Edit(title = "卡失效时间", notNull = false, show = false)
    )
    private String endTime;

    @EruptField(
            views = @View(title = "会员卡类型"),
            edit = @Edit(title = "会员卡类型", notNull = true, type = EditType.CHOICE, choiceType = @ChoiceType(
                    vl = {
                            @VL(label = "年卡", value = "年卡"),
                            @VL(label = "季卡", value = "季卡"),
                            @VL(label = "月卡", value = "月卡"),
                            @VL(label = "周卡", value = "周卡"),
                    }
            ))
    )
    private String cardType;

    @EruptField(
            views = @View(title = "是否在有效期内"),
            edit = @Edit(title = "是否在有效期内", notNull = true)
    )
    private Boolean isExpired;

    @EruptField(
            views = @View(title = "签到次数"),
            edit = @Edit(title = "签到次数", notNull = false, show = false)
    )
    private String signIn;

    @EruptField(
            views = @View(title = "卡号"),
            edit = @Edit(title = "卡号", notNull = false, show = false, search = @Search(vague = true))
    )
    private String cardNum;

    @EruptField(
            views = @View(title = "联系方式"),
            edit = @Edit(title = "联系方式", notNull = true, search = @Search(vague = true))
    )
    private String phoneNumber;


}
