package com.vip.zn.fitness_system.db.service.impl;

import com.vip.zn.fitness_system.db.mapper.CoachMapper;
import com.vip.zn.fitness_system.db.model.Coach;
import com.vip.zn.fitness_system.db.model.User;
import com.vip.zn.fitness_system.db.service.CoachDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CoachDataServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 21:24
 */

@Service
public class CoachDataServiceImpl implements CoachDataService {

    @Autowired
    CoachMapper coachMapper;

    @Override
    public int insertSelective(Coach coach) {
        return coachMapper.insertSelective(coach);
    }

    @Override
    public int updateSelective(Coach coach) {
        return coachMapper.updateByPrimaryKeySelective(coach);
    }

    @Override
    public List<Coach> selectByName(String name) {
        return coachMapper.selectByCoachName(name);
    }

    @Override
    public List<Coach> selectByPhone(String phoneNum) {
        return coachMapper.selectByCoachPhone(phoneNum);
    }

    @Override
    public List<Coach> selectByCoachId(String coachId) {
        return coachMapper.selectByCoachId(coachId);
    }

    @Override
    public Coach selectById(Integer id) {
        return coachMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return coachMapper.deleteByPrimaryKey(id);
    }
}
