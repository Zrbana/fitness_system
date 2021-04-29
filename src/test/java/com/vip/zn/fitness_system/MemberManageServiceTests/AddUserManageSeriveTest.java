package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName AddUserManageSeriveTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 19:26
 */

@SpringBootTest
public class AddUserManageSeriveTest extends BaseTestNGTestCase {

    @Autowired
    MemberManageController memberManageController;

    @Test(description = "新增成功")
    public void testAddUserMethodCase00(){
        AddUserInfoReq req = new AddUserInfoReq();
        req.setName("jj");
        req.setCardType((byte)1);
        req.setGender((byte)1);
        req.setCardType((byte)1);
        req.setPhoneNumber("123456");
        WebResult webResult = memberManageController.addUserInfo(req);
        Assert.assertEquals(webResult.getCode(),"200");
    }
}










