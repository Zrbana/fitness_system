package com.example.demo.dataProxy;

import com.example.demo.entity.Coach;
import com.example.demo.entity.Course;
import com.example.demo.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.jpa.dao.EruptDao;

/**
 * @ClassName CourseDataProxy
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 17:26
 */

@Service
public class CourseDataProxy implements DataProxy<Course> {

    @Autowired
    EruptDao eruptDao;

    @Autowired
    CoachRepository coachRepository;

    @Override
    public void beforeAdd(Course course) {
        //通过coachName查coachID
        Coach coach = coachRepository.findByName(course.getCoachName());
        if (coach == null) {
            throw new EruptApiErrorTip("请检查私教姓名是否输入正确！");
        }
        course.setCoachId(coach.getCoachNumber());
    }
}
