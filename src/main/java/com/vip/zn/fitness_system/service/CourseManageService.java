package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddCourseReq;
import com.vip.zn.fitness_system.dto.CourseDto;
import org.springframework.stereotype.Service;

@Service
public interface CourseManageService {
    /**
     * 新增课程信息
     */
    WebResult addCourseInfo(AddCourseReq req);

    /**
     * 修改课程信息
     */
    WebResult updateCourseInfo(CourseDto courseDto);

    /**
     * 删除课程信息
     */
    WebResult deleteCourseInfo(Integer id);

    /**
     * 查询一周课程信息
     */
    WebResult getAllCourseInfo();

}
