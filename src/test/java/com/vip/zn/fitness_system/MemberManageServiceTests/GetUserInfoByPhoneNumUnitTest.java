package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.alibaba.fastjson.JSON;
import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.dto.GetUserInfoByNameReq;
import com.vip.zn.fitness_system.dto.GetUserInfoByPhoneNumReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName GetUserInfoByPhoneNumUnitTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 17:27
 */

@SpringBootTest
@Slf4j
public class GetUserInfoByPhoneNumUnitTest extends BaseTestNGTestCase {

    @Autowired
    MemberManageController memberManageController;

    @Test(description = "按照电话查询用户信息--有记录")
    public void testCase00(){
        GetUserInfoByPhoneNumReq req = new GetUserInfoByPhoneNumReq();
        req.setPhoneNumber("5201");
        WebResult webResult = memberManageController.getUserInfoByPhoneNum(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getCode(),"200");
    }

    @Test(description = "按照名字查询用户信息--无记录 预期data=[]")
    public void testCase01(){
        GetUserInfoByPhoneNumReq req = new GetUserInfoByPhoneNumReq();
        req.setPhoneNumber("888888888");
        WebResult webResult = memberManageController.getUserInfoByPhoneNum(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getData().toString(),"[]");
    }

}
