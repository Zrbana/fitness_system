package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.CourseDto;
import com.vip.zn.fitness_system.service.CourseManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CourseManageController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/27 11:42
 */

@RestController
@RequestMapping(value = "/course")
@Api("课程管理接口")
public class CourseManageController {

    @Autowired
    CourseManageService courseManageService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增课程信息")
    public WebResult addCourseInfo(CourseDto courseDto) {
        return courseManageService.addCourseInfo(courseDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation("删除课程信息")
    public WebResult deleteCourseInfo(Integer id) {
        return courseManageService.deleteCourseInfo(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改课程信息")
    public WebResult updateCourseInfo(CourseDto courseDto) {
        return courseManageService.updateCourseInfo(courseDto);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    @ApiOperation("修改课程信息")
    public WebResult getAllCourseInfo() {
        return courseManageService.getAllCourseInfo();
    }
}
