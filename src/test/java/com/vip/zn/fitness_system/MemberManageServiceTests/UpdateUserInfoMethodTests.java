package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.service.MemberManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * @ClassName UpdateUserInfoMethodTests
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 18:05
 */

@SpringBootTest
public class UpdateUserInfoMethodTests extends BaseTestNGTestCase {

    @Autowired
    MemberManageService memberManageService;

    @Test(description = "修改某一字段")
    public void testUpdateUserInfoCase00() {
        AddUserInfoReq req = new AddUserInfoReq();
        req.setName("小春");
        memberManageService.addOrUpdateUser(req);
    }

}
