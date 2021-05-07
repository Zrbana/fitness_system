package com.example.demo.entity;

import com.example.demo.dataProxy.OrderCourseDataProxy;
import com.example.demo.handler.OperationHandlerImpl;
import com.example.demo.handler.OrderCourseHandlerImpl;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.expr.ExprBool;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.handler.ViaMenuCtrl;
import xyz.erupt.upms.handler.ViaMenuValueCtrl;

import javax.persistence.Entity;

/**
 * @ClassName OrderCourseButton
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 13:21
 */

@Erupt(
        name = "Erupt",
        rowOperation = {
                @RowOperation(
                        title = "按钮操作",
                        code = "BUTTON",
                        operationHandler = OperationHandlerImpl.class,
                        mode = RowOperation.Mode.BUTTON,
                        tip = "不依赖任何数据即可执行"),

        }
)
@Data
@Entity
public class OrderCourseButton extends BaseModel {
}
