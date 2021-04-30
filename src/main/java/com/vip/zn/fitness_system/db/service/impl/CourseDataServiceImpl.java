package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.mapper.CourseMapper;
import com.vip.zn.fitness_system.db.model.Course;
import com.vip.zn.fitness_system.db.service.CourseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CourseDataServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/30 14:25
 */

@Service
public class CourseDataServiceImpl implements CourseDataService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int insertSelective(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public int updateSelective(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }
}
