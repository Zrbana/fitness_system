package com.vip.zn.fitness_system.db.service;

import com.vip.zn.fitness_system.db.model.Coach;
import com.vip.zn.fitness_system.db.model.Course;

import java.util.List;

/**
 * @ClassName CourseDataService
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/30 14:25
 */


public interface CourseDataService {
    int insertSelective(Course course);

    int updateSelective(Course course);
}
