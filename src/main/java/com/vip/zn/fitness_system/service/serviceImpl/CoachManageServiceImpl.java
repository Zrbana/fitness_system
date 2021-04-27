package com.vip.zn.fitness_system.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dbgenerator.entity.Coach;
import com.vip.zn.fitness_system.dbgenerator.mapper.CoachMapper;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import com.vip.zn.fitness_system.dto.CoachDto;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.CoachManageService;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TrainerManageServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:06
 */

@Service
public class CoachManageServiceImpl implements CoachManageService {
    @Autowired
    CoachMapper coachMapper;

    @Override
    public WebResult addCoach(AddCoachInfoReq req) {
        if (StringUtils.isBlank(req.getPhoneNumber()) || StringUtils.isBlank(req.getCoachName())) {
            return WebResult.buildFail("联系方式或姓名不允许为空");
        }
        Coach coach = new Coach();
        try {
            coach.setPhoneNumber(req.getPhoneNumber());
            coach.setStatus(req.getStatus().getStatusCode());
            coach.setCoachId(FitnessDefaultUtils.randomCoachID());
            coachMapper.insert(coach);
        } catch (BizException e) {
            return WebResult.buildFail("添加私教信息失败");
        }
        return WebResult.buildSucc("添加私教信息成功", "200", coach);
    }

    @Override
    public WebResult updateCoachInfo(CoachDto teacherDto) {
        return null;
    }

    @Override
    public WebResult deleteCoachInfo(Integer id) {
        if (id.equals(null)) {
            return WebResult.buildFail("删除失败");
        }
        coachMapper.deleteById(id);
        return WebResult.buildSucc("删除成功");
    }

    @Override
    public WebResult getCoachInfoByCoachId(String teacherId) {
        if (teacherId == null || StringUtils.isBlank(teacherId)) {
            return WebResult.buildFail("查询失败");
        }
        List<Coach> queryList;
        try {
            queryList = coachMapper.selectList(new QueryWrapper<Coach>().like("coachId", teacherId));
        } catch (BizException e) {
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功", "200", queryList);
    }

    @Override
    public WebResult getCoachInfoByName(String name) {
        if (name == null || StringUtils.isBlank(name)) {
            return WebResult.buildFail("查询失败");
        }
        List<Coach> queryList;
        try {
            queryList = coachMapper.selectList(new QueryWrapper<Coach>().like("coachName", name));
        } catch (BizException e) {
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功", "200", queryList);
    }


    @Override
    public WebResult getCoachInfoByPhoneNum(String phoneNum) {
        if (phoneNum == null || StringUtils.isBlank(phoneNum)) {
            return WebResult.buildFail("查询失败");
        }
        List<Coach> queryList;
        try {
            queryList = coachMapper.selectList(new QueryWrapper<Coach>().like("phoneNumber", phoneNum));
        } catch (BizException e) {
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功", "200", queryList);
    }
}

