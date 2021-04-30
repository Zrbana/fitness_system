package com.vip.zn.fitness_system.service.impl;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.model.Course;
import com.vip.zn.fitness_system.db.service.CoachDataService;
import com.vip.zn.fitness_system.db.service.CourseDataService;
import com.vip.zn.fitness_system.dto.AddCourseReq;
import com.vip.zn.fitness_system.dto.CourseDto;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.CourseManageService;
import com.vip.zn.fitness_system.utils.CheckUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CourseManageServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/30 13:32
 */

@Service
public class CourseManageServiceImpl implements CourseManageService {

    @Autowired
    CourseDataService courseDataService;

    @Autowired
    CoachDataService coachDataService;

    @Override
    public WebResult addCourseInfo(AddCourseReq req) {
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getCourseName()), "课程名不允许为空！");
        CheckUtils.assertTrue(req != null && StringUtils.isNotBlank(req.getCoachName()), "私教姓名不允许为空！");
        CheckUtils.assertTrue(req.getCourseBeginTime().compareTo(req.getCourseEndTime()) <= 0, "课程开始时间不能大于课程结束时间");
        Course course = new Course();
        try {
            course.setCourseBeginTime(req.getCourseBeginTime());
            course.setCourseEndTime(req.getCourseEndTime());
            course.setTeacherName(req.getCoachName());
            course.setTeacherId(coachDataService.selectIdByName(req.getCoachName()).getCoachId());
            course.setCourseName(req.getCourseName());
            courseDataService.insertSelective(course);
        }catch (BizException e){
            return WebResult.buildFail("新增课程失败",e.getErrorMsg());
        }
        return WebResult.buildSucc("新增课程成功");
    }

    @Override
    public WebResult updateCourseInfo(CourseDto courseDto) {
        return null;
    }

    @Override
    public WebResult deleteCourseInfo(Integer id) {
        return null;
    }

    @Override
    public WebResult getAllCourseInfo() {
        return null;
    }
}
