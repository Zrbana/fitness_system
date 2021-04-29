package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.controller.MemberManageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName MemberQueryServieTests
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/29 21:06
 */

@Test
public class MemberQueryServiceTests extends BaseTestNGTestCase {

    @Autowired
    MemberManageController memberManageController;

    @Test(description = "根据姓名查询")
    public void testQueryByNameCase00(){
        Assert.assertEquals(memberManageController.getUserInfoByName("j").getCode(),"200");
    }

    @Test(description = "根据电话号码查询")
    public void testQueryByPhoneNumCase01(){
        Assert.assertEquals(memberManageController.getUserInfoByCardNum("12").getCode(),"200");
    }

    @Test(description = "根据卡号查询")
    public void testQueryByCardNumCase02(){
        Assert.assertEquals(memberManageController.getUserInfoByCardNum("jk935356").getCode(),"200");
    }
}
