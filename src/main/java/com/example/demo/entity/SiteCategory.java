package com.example.demo.entity;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @ClassName SiteCategory
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 21:23
 */



@Erupt(name = "场地类别", tree = @Tree(pid = "parent.id"), orderBy = "SiteCategory.sort")
@Entity
public class SiteCategory extends BaseModel {

    @EruptField(
            edit = @Edit(title = "分类图片", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String image;

    @EruptField(
            edit = @Edit(title = "类别名称", notNull = true)
    )
    private String name;

    @EruptField(
            edit = @Edit(title = "显示顺序")
    )
    private Integer sort;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "上级分类", type = EditType.REFERENCE_TREE, referenceTreeType = @ReferenceTreeType(pid = "parent.id"))
    )
    private SiteCategory parent;


}
