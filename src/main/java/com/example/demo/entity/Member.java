package com.example.demo.entity;

import com.example.demo.dataProxy.UserDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;

/**
 * @ClassName Member
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 9:25
 */

@Data
@Erupt(name = "会员信息表",
        power = @Power(add = true, delete = true,
                edit = true, query = true,
                importable = false, export = false),
        dataProxy = UserDataProxy.class
)
@Entity
public class Member extends BaseModel {

}
