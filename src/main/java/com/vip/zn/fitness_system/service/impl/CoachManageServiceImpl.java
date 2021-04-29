package com.vip.zn.fitness_system.service.impl;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.model.Coach;
import com.vip.zn.fitness_system.db.service.CoachDataService;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import com.vip.zn.fitness_system.dto.CoachDto;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.CoachManageService;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CoachManageServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 21:19
 */

@Service
public class CoachManageServiceImpl implements CoachManageService {

    @Autowired
    CoachDataService coachDataService;

    @Override
    public WebResult addCoach(AddCoachInfoReq req) {
        if (StringUtils.isBlank(req.getName()) || StringUtils.isBlank(req.getPhoneNumber())) {
            WebResult.buildFail("请检查输入的信息是否完整");
        }
        Coach coachInfo = new Coach();
        coachInfo.setCoachId(FitnessDefaultUtils.randomCoachID());
        coachInfo.setCoachName(req.getName());
        coachInfo.setPhoneNumber(req.getPhoneNumber());
        coachInfo.setStatus((byte) 0);
        try {
            coachDataService.insertSelective(coachInfo);
        } catch (BizException e) {
            return WebResult.buildFail("新增私教信息失败", e.getErrorMsg());
        }
        return WebResult.buildSucc("新增私教信息成功");
    }

    @Override
    public WebResult updateCoachInfo(CoachDto teacherDto) {
        return null;
    }

    @Override
    public WebResult deleteCoachInfo(Integer id) {
        coachDataService.deleteByPrimaryKey(id);
        return WebResult.buildSucc("删除成功");
    }

    @Override
    public WebResult getCoachInfoByCoachId(String coachId) {
        if(StringUtils.isBlank(coachId)){
            WebResult.buildFail("查询条件为空");
        }
        try {
            coachDataService.selectByCoachId(coachId);
        }catch (BizException e){
            WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功");
    }

    @Override
    public WebResult getCoachInfoByName(String name) {
        if(StringUtils.isBlank(name)){
            WebResult.buildFail("查询条件为空");
        }
        try {
            coachDataService.selectByName(name);
        }catch (BizException e){
            WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功");
    }

    @Override
    public WebResult getCoachInfoByPhoneNum(String phoneNum) {
        if(StringUtils.isBlank(phoneNum)){
            WebResult.buildFail("查询条件为空");
        }
        try {
            coachDataService.selectByPhone(phoneNum);
        }catch (BizException e){
            WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功");
    }
}
