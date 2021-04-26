package com.vip.zn.fitness_system.DBServiceTests;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.db.entity.User;
import com.vip.zn.fitness_system.db.mapper.UserMapper;
import com.vip.zn.fitness_system.db.service.impl.UserServiceImpl;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
/**
 * @ClassName MemberDataServiceUnitTests
 * @Description 测试操作数据库的增删改查
 * @Author na.zhao
 * @Date 2021/4/25 15:08
 */

@Slf4j
@SpringBootTest
public class MemberDataServiceUnitTests extends BaseTestNGTestCase {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MemberManageController memberManageController;

    @Test(description = "插入user表")
    public void testInsertIntoTableUser() {
        User user = new User();
        user.setName("用户1");
        user.setBeginTime(LocalDate.now());
        user.setEndTime(LocalDate.now());
        user.setCardNum(FitnessDefaultUtils.randomCardNum("nk"));
        user.setCardType(0);
        user.setGender(0);
        user.setIsExpired(0);
        user.setPhoneNumber("18792779351");
        boolean isSave = userService.save(user);
        Assert.assertEquals(isSave, true);
    }

    @Test(description = "更新user表")
    //TODO
    public void testUpdateTableUser() {
        User user = new User();
        userService.update().setSql("update user set name='用户1' where name='newName'");
    }

    @Test(description = "按照名字在user表查询单条用户信息----不适用")
    public void testQueryByNameSingleScore() {
        //getOne()只能查出一条结果，否则会抛TooManyResultsException异常
        User queryResult = userService.getOne(new QueryWrapper<User>().eq("name", "赵娜").last("limit 1"));
        Assert.assertNotNull(queryResult);
    }

    @Test(description = "查询某一列数据，其他列结果均为Null")
    public void testQueryByNameManyResult() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("name");
        userMapper.selectList(queryWrapper).forEach(logger::info);
        Assert.assertNotNull(queryWrapper);
    }

    @Test
    public void testUserMapperMethod() {
        AddUserInfoReq req = new AddUserInfoReq();
        req.setCardType(CardTypeEnum.MONTH_CARD);
        req.setGender(0);
        req.setName("陈");
        req.setPhoneNumber("112233");
        WebResult webResult = memberManageController.addUserInfo(req);
        logger.info(webResult.toString());
    }
}
