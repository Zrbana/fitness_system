package com.example.demo.handler;

import com.example.demo.entity.OrderCourse;
import com.example.demo.entity.OrderCourseButton;
import xyz.erupt.annotation.fun.OperationHandler;

import java.util.List;

/**
 * @ClassName OrderCourseHandlerImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 13:28
 */

/**
 * OrderCourseButton 目标数据类型
 * OrderCourse  erupt支持使用另一个erupt类作为表单输入框而存在
 */
public class OrderCourseHandlerImpl implements OperationHandler<OrderCourseButton, OrderCourse> {
    @Override
    public void exec(List<OrderCourseButton> data, OrderCourse orderCourse, String[] param) {

    }
}
