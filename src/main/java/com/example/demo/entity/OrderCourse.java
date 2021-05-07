package com.example.demo.entity;

import com.example.demo.dataProxy.CourseDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import java.math.BigInteger;

/**
 * @ClassName OrderClass
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 11:11
 */

@Data
@Entity
@Erupt(name = "预约课程表",
        power = @Power(add = true, delete = true,
                edit = true, query = true,
                importable = false, export = false),
        dataProxy = CourseDataProxy.class
)
public class OrderCourse extends BaseModel {
    @EruptField(
            views = @View(title = "课程ID"),
            edit = @Edit(title = "课程ID", notNull = false, search = @Search(vague = true))
    )
    private BigInteger courseId;
}
