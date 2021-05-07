package com.example.demo.entity;

import com.example.demo.model.mall.GoodsCategory;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @ClassName Site
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 17:07
 */

@Erupt(name = "场地管理", linkTree = @LinkTree(field = "category"))
@Entity
public class Site extends BaseModel {
    @EruptField(
            views = @View(title = "场地图片"),
            edit = @Edit(title = "场地图片", notNull = true, type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE, maxLimit = 6))
    )
    private String image;
    @EruptField(
            views = @View(title = "场地名称"),
            edit = @Edit(title = "场地名称", notNull = true, inputType = @InputType(fullSpan = true), search = @Search(vague = true))
    )
    private String name;
    @EruptField(
            views = @View(title = "预约状态"),
            edit = @Edit(title = "预约状态", notNull = true, boolType = @BoolType(trueText = "可预约", falseText = "已预约"), search = @Search)
    )
    private Boolean status;
    @ManyToOne
    @EruptField(
            views = @View(title = "所属分类", column = "name"),
            edit = @Edit(title = "所属分类", type = EditType.REFERENCE_TREE, search = @Search, notNull = true, referenceTreeType = @ReferenceTreeType(pid = "parent.id"))
    )
    private GoodsCategory category;


    @EruptField(
            views = @View(title = "联系人"),
            edit = @Edit(title = "联系人", notNull = true, search = @Search(vague = true))
    )
    private String contact;

    @EruptField(
            views = @View(title = "联系电话"),
            edit = @Edit(title = "联系电话", notNull = true, search = @Search(vague = true))
    )
    private String contactPhone;

    @EruptField(
            views = @View(title = "使用开始时间"),
            edit = @Edit(title = "使用开始时间", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private String useBeginTime;
    @EruptField(
            views = @View(title = "使用结束时间"),
            edit = @Edit(title = "使用结束时间", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private String useEndTime;

}
