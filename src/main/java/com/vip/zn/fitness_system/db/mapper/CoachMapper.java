package com.vip.zn.fitness_system.db.mapper;

import com.vip.zn.fitness_system.db.model.Coach;
import com.vip.zn.fitness_system.db.model.Course;

import java.util.List;

public interface CoachMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);

    List<Coach> selectByCoachName(String coachName);

    List<Coach> selectByCoachId(String coachId);

    List<Coach> selectByCoachPhone(String coachPhone);

    //根据coachName得到coachId
    Coach selectIdByName(String coachName);
}