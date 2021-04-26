package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.alibaba.fastjson.JSON;
import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.dto.GetUserInfoByCardNumReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName GetUserInfoByCardNumUnitTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 17:42
 */

@SpringBootTest
@Slf4j
public class GetUserInfoByCardNumUnitTest extends BaseTestNGTestCase {
    @Autowired
    MemberManageController memberManageController;

    @Test(description = "按照卡号查询用户信息--有记录")
    public void testCase00(){
        GetUserInfoByCardNumReq req = new GetUserInfoByCardNumReq();
        req.setCardNum("nk");
        WebResult webResult = memberManageController.getUserInfoByCardNum(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getCode(),"200");
    }

    @Test(description = "按照卡号查询用户信息--无记录 预期data=[]")
    public void testCase01(){
        GetUserInfoByCardNumReq req = new GetUserInfoByCardNumReq();
        req.setCardNum("nnnnk");
        WebResult webResult = memberManageController.getUserInfoByCardNum(req);
        log.info(JSON.parseObject(webResult.toString())+"////////////////////////");
        Assert.assertEquals(webResult.getData().toString(),"[]");
    }

}
