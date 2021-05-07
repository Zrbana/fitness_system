package com.example.demo.entity;

import com.example.demo.dataProxy.CoachDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.time.LocalDate;

/**
 * @ClassName CoachInfo
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 17:01
 */

@Data
@Erupt(name = "私教信息表",
        power = @Power(add = true, delete = true,
                edit = true, query = true,
                importable = false, export = false),
        dataProxy = CoachDataProxy.class
)
@Entity
public class Coach extends BaseModel {

    @EruptField(
            views = {
                    @View(title = "私教照片", type = ViewType.IMAGE)
            },
            edit = @Edit(title = "私教照片", notNull = true, type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String image;

    @EruptField(
            views = @View(title = "私教ID"),
            edit = @Edit(title = "私教ID", notNull = false, show = false, search = @Search(vague = true))
    )
    private String coachNumber;

    @EruptField(
            views = @View(title = "私教姓名"),
            edit = @Edit(title = "私教姓名", notNull = true, search = @Search(vague = true))
    )
    private String coachName;

    @EruptField(
            views = @View(title = "性别"),
            edit = @Edit(title = "性别", notNull = true)
    )
    private String gender;

    @EruptField(
            views = @View(title = "入职时间"),
            edit = @Edit(title = "入职时间", notNull = false, show = false)
    )
    private LocalDate beginTime;


    @EruptField(
            views = @View(title = "是否在职"),
            edit = @Edit(title = "是否在职", notNull = true)
    )
    private Boolean status;

    //简历介绍内容定义为大文本类型
    @Lob
    @EruptField(
            views = @View(title = "简历", type = ViewType.HTML),
            edit = @Edit(title = "简历", notNull = true, type = EditType.HTML_EDITOR)
    )
    private String content;


    @EruptField(
            views = @View(title = "联系方式"),
            edit = @Edit(title = "联系方式", notNull = true, search = @Search(vague = true))
    )
    private String phoneNumber;
}
