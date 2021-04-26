package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.db.entity.Teacher;
import com.vip.zn.fitness_system.dto.TeacherDto;

public interface TrainerManageService {
    /**
     * 新增私教信息
     * @param teacherDto
     * @return
     */
    Teacher addTeacher(TeacherDto teacherDto);

    /**
     * 修改私教信息
     * @param teacherDto
     * @return
     */
    Teacher updateTeacherInfo(TeacherDto teacherDto);

    /**
     * 删除私教信息
     * @param teacherDto
     * @return
     */
    Teacher deleteTeacherInfo(TeacherDto teacherDto);

    /**
     * 根据私教id查询私教信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherInfoByTeacherId(String teacherId);

    /**
     * 根据私教姓名查询私教信息
     * @param name
     * @return
     */
    Teacher getTeacherInfoByName(String name);

    /**
     * 根据手机号码查询私教信息
     * @param phoneNum
     * @return
     */
    Teacher getTeacherInfoByPhoneNum(String phoneNum);
}
