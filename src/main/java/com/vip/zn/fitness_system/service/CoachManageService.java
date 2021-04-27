package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import com.vip.zn.fitness_system.dto.CoachDto;

public interface CoachManageService {
    /** 新增私教信息 */
    WebResult addCoach(AddCoachInfoReq req);

    /** 修改私教信息 */
    WebResult updateCoachInfo(CoachDto teacherDto);

    /** 删除私教信息 */
    WebResult deleteCoachInfo(Integer id);

    /** 根据私教id模糊查询私教信息 */
    WebResult getCoachInfoByCoachId(String teacherId);

    /** 根据私教姓名查询私教信息 */
    WebResult getCoachInfoByName(String name);

    /** 根据手机号码查询私教信息 */
    WebResult getCoachInfoByPhoneNum(String phoneNum);
}
