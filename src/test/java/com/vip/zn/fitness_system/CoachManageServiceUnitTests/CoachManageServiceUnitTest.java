package com.vip.zn.fitness_system.CoachManageServiceUnitTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.controller.CoachManageController;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName TrainerManageServiceUnitTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 23:20
 */

@SpringBootTest
public class CoachManageServiceUnitTest extends BaseTestNGTestCase {

    @Autowired
    CoachManageController coachManageController;

    @Test(description = "新增私教信息")
    public void addTrainerInfoMethodCase01(){
        AddCoachInfoReq req = new AddCoachInfoReq();
        req.setName("张家赫");
        req.setPhoneNumber("123456");
        Assert.assertEquals(coachManageController.addCoachInfo(req).getCode(),"200");
    }

    @Test(description = "根据私教id查询")
    public void addTrainInfoMethodCase02(){
        Assert.assertEquals(coachManageController.getCoachInfoByCoachId("578").getCode(),"200");
    }

    @Test(description = "根据私教姓名查询")
    public void addTrainInfoMethodCase03() {
        Assert.assertEquals(coachManageController.getCoachInfoByName("张").getCode(), "200");
    }

    @Test(description = "根据私教电话查询")
    public void addTrainInfoMethodCase04() {
        Assert.assertEquals(coachManageController.getCoachInfoByPhoneNum("123").getCode(), "200");
    }

}
