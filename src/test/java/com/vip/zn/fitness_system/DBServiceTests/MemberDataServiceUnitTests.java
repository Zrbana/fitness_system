package com.vip.zn.fitness_system.DBServiceTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.db.model.User;
import com.vip.zn.fitness_system.db.service.MemberDataService;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.utils.FitnessDefaultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    MemberDataService memberDataService;

    @Test(description = "向user表插入数据")
    public void testInsertMethod() {
        User user = new User();
        user.setName("泡泡龙");
        user.setBeginTime(LocalDate.now());
        user.setEndTime(LocalDate.now().plusWeeks(1L));
        user.setCardNum(FitnessDefaultUtils.randomCardNum("zk"));
        user.setGender((byte) 0);
        user.setIsExpired((byte) 0);
        user.setPhoneNumber("123");
        user.setCardType((byte) 1);
        int result = memberDataService.insertSelective(user);
        Assert.assertEquals(result, 1);
    }

    @Test(description = "根据名字查询用户列表")
    public void testQueryByName() {
        List<User> list = memberDataService.selectByName("小仔仔");
        Assert.assertNotNull(list);
    }

    @Test(description = "根据名字查询用户列表")
    public void testQueryByPhone() {
        List<User> list = memberDataService.selectByPhone("123");
        Assert.assertNotNull(list);
    }

    @Test(description = "更新会员信息")
    public void testUpdateMethod(){
        User user = new User();
        user.setName("旺仔");
        int res = memberDataService.updateSelective(user);
        Assert.assertEquals(res,1);
    }

}











