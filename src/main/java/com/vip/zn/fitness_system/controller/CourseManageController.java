package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddCourseReq;
import com.vip.zn.fitness_system.service.CourseManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CourseManageController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/30 13:20
 */

@RestController
@RequestMapping(value = "/course")
@Api("课程管理接口")
public class CourseManageController {

    @Autowired
    CourseManageService courseManageService;

    @ApiOperation("新增会员信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public WebResult addCourse(@RequestBody AddCourseReq req) {
        return courseManageService.addCourseInfo(req);
    }
}
