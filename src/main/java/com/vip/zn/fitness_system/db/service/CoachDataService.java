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
    int insertSelective(Coach coach);

    int updateSelective(Coach coach);

    List<Coach> selectByName(String name);

    List<Coach> selectByPhone(String phoneNum);

    List<Coach> selectByCoachId(String coachId);

    Coach selectById(Integer id);

    int deleteByPrimaryKey(Integer id);

    Coach selectIdByName(String coachName);
}
