package com.vip.zn.fitness_system.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Teacher;
import com.vip.zn.fitness_system.db.mapper.TeacherMapper;
import com.vip.zn.fitness_system.dto.AddTeacherInfoReq;
import com.vip.zn.fitness_system.dto.TeacherDto;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.TrainerManageService;
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
public class TrainerManageServiceImpl implements TrainerManageService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public WebResult addTeacher(AddTeacherInfoReq req) {
        if (StringUtils.isBlank(req.getPhoneNumber()) || StringUtils.isBlank(req.getTeacherName())) {
            return WebResult.buildFail("联系方式或姓名不允许为空");
        }
        Teacher teacher = new Teacher();
        try {
            teacher.setPhoneNumber(req.getPhoneNumber());
            teacher.setStatus(req.getStatus().getStatusCode());
            teacher.setTeacherId(FitnessDefaultUtils.randomTeacherID());
            teacherMapper.insert(teacher);
        } catch (BizException e) {
            return WebResult.buildFail("添加私教信息失败");
        }
        return WebResult.buildSucc("添加私教信息成功", "200", teacher);
    }

    @Override
    public WebResult updateTeacherInfo(TeacherDto teacherDto) {
        return null;
    }

    @Override
    public WebResult deleteTeacherInfo(Integer id) {
        if(id.equals(null)){
            return WebResult.buildFail("删除失败");
        }
        teacherMapper.deleteById(id);
        return WebResult.buildSucc("删除成功");
    }

    @Override
    public WebResult getTeacherInfoByTeacherId(String teacherId) {
        if (teacherId == null || StringUtils.isBlank(teacherId)) {
           return WebResult.buildFail("查询失败");
        }
        List<Teacher> queryList;
        try {
           queryList =  teacherMapper.selectList(new QueryWrapper<Teacher>().like("teacherId",teacherId));
        }catch (BizException e){
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功","200",queryList);
    }

    @Override
    public WebResult getTeacherInfoByName(String name) {
        if (name == null || StringUtils.isBlank(name)) {
            return WebResult.buildFail("查询失败");
        }
        List<Teacher> queryList;
        try {
            queryList =  teacherMapper.selectList(new QueryWrapper<Teacher>().like("teacherName",name));
        }catch (BizException e){
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功","200",queryList);    }

    @Override
    public WebResult getTeacherInfoByPhoneNum(String phoneNum) {
        if (phoneNum == null || StringUtils.isBlank(phoneNum)) {
            return WebResult.buildFail("查询失败");
        }
        List<Teacher> queryList;
        try {
            queryList =  teacherMapper.selectList(new QueryWrapper<Teacher>().like("phoneNumber",phoneNum));
        }catch (BizException e){
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询成功","200",queryList);
    }
}
