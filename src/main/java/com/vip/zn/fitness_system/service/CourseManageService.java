package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.db.entity.Course;
import com.vip.zn.fitness_system.dto.CourseDto;

import java.util.List;

public interface CourseManageService {
    /**
     * 新增课程信息
     * @param courseDto
     * @return
     */
    Course addCourseInfo(CourseDto courseDto);

    /**
     * 修改课程信息
     * @param courseDto
     * @return
     */
    Course updateCourseInfo(CourseDto courseDto);

    /**
     * 删除课程信息
     * @param courseDto
     */
    void deleteCourseInfo(CourseDto courseDto);

    /**
     * 查询一周课程信息
     * @return
     */
    List<Course> getAllCourseInfo();

}
