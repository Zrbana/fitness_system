package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.alibaba.fastjson.JSON;
import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.dto.GetUserInfoByNameReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * @ClassName GetUserInfoByNameMethodUnitTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 17:07
 */

@SpringBootTest
@Slf4j
public class GetUserInfoByNameMethodUnitTest extends BaseTestNGTestCase {

    @Autowired
    MemberManageController memberManageController;

    @Test(description = "按照名字查询用户信息--有记录")
    public void testCase00(){
        GetUserInfoByNameReq req = new GetUserInfoByNameReq();
        req.setName("赵娜");
        WebResult webResult = memberManageController.getUserInfoByName(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getCode(),"200");
    }

    @Test(description = "按照名字查询用户信息--无记录 预期data=[]")
    public void testCase01(){
        GetUserInfoByNameReq req = new GetUserInfoByNameReq();
        req.setName("赵娜中安安安安安");
        WebResult webResult = memberManageController.getUserInfoByName(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getData().toString(),"[]");
    }

}
