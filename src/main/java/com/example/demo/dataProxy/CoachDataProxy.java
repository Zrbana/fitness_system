package com.example.demo.dataProxy;

import com.example.demo.entity.Coach;
import com.example.demo.utils.FitnessDefaultUtils;
import xyz.erupt.annotation.fun.DataProxy;

import java.time.LocalDate;

/**
 * @ClassName CoachInfoProxy
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 17:01
 */


public class CoachDataProxy implements DataProxy<Coach> {
    @Override
    public void beforeAdd(Coach coachInfo) {
        //生成私教id
        coachInfo.setCoachNumber(FitnessDefaultUtils.randomCoachID());
        coachInfo.setBeginTime(LocalDate.now());
    }
}
