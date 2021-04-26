package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddTeacherInfoReq;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.TeacherDto;

public interface TrainerManageService {
    /** 新增私教信息 */
    WebResult addTeacher(AddTeacherInfoReq req);

    /** 修改私教信息 */
    WebResult updateTeacherInfo(TeacherDto teacherDto);

    /** 删除私教信息 */
    WebResult deleteTeacherInfo(Integer id);

    /** 根据私教id查询私教信息 */
    WebResult getTeacherInfoByTeacherId(String teacherId);

    /** 根据私教姓名查询私教信息 */
    WebResult getTeacherInfoByName(String name);

    /** 根据手机号码查询私教信息 */
    WebResult getTeacherInfoByPhoneNum(String phoneNum);
}
