package com.vip.zn.fitness_system.db.service;

import com.vip.zn.fitness_system.db.model.Coach;
import com.vip.zn.fitness_system.db.model.User;

import java.util.List;

/**
 * @ClassName CoachDataService
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 21:20
 */


public interface CoachDataService {
    public int insertSelective(Coach coach);

    public int updateSelective(Coach coach);

    public List<Coach> selectByName(String name);

    public List<Coach> selectByPhone(String phoneNum);

    public List<Coach> selectByCoachId(String coachId);

    public Coach selectById(Integer id);

    public int deleteByPrimaryKey(Integer id);
}
