package com.example.demo.entity;

import com.example.demo.dataProxy.CourseDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;

/**
 * @ClassName Course
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 17:10
 */

@Data
@Erupt(name = "课程信息表",
        power = @Power(add = true, delete = true,
                edit = true, query = true,
                importable = false, export = false),
        dataProxy = CourseDataProxy.class
)
@Entity
public class Course extends BaseModel {
    @EruptField(
            views = @View(title = "课程名称"),
            edit = @Edit(title = "课程名称", notNull = true, search = @Search(vague = true))
    )
    private String courseName;

    @EruptField(
            views = @View(title = "课程开始时间"),
            edit = @Edit(title = "课程开始时间", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private String beginTime;

    @EruptField(
            views = @View(title = "课程结束时间"),
            edit = @Edit(title = "课程结束时间", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private String endTime;


    @EruptField(
            views = @View(title = "上课老师姓名"),
            edit = @Edit(title = "上课老师姓名", notNull = true, search = @Search(vague = true))
    )
    private String coachName;

    @EruptField(
            views = @View(title = "教师ID"),
            edit = @Edit(title = "教师ID", notNull = false, show = false, search = @Search(vague = true))
    )
    private String coachId;

    @EruptField(
            views = @View(title = "报名人数"),
            edit = @Edit(title = "报名人数", notNull = false, show = false)
    )
    private String applyNumber;
}
