package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Course;
import com.vip.zn.fitness_system.dto.CourseDto;

import java.util.List;

public interface CourseManageService {
    /** 新增课程信息 */
    WebResult addCourseInfo(CourseDto courseDto);

    /** 修改课程信息 */
    WebResult updateCourseInfo(CourseDto courseDto);

    /** 删除课程信息 */
    WebResult deleteCourseInfo(Integer id);

    /** 查询一周课程信息 */
    WebResult getAllCourseInfo();

}
