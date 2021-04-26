package com.vip.zn.fitness_system.MemberManageServiceTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.controller.MemberManageController;
import com.vip.zn.fitness_system.db.entity.Account;
import com.vip.zn.fitness_system.dto.AccountDto;
import com.vip.zn.fitness_system.dto.AddUserInfoReq;
import com.vip.zn.fitness_system.dto.dtoMapper.DtoAndEntityConvertor;
import com.vip.zn.fitness_system.enums.CardTypeEnum;
import com.vip.zn.fitness_system.service.MemberManageService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @ClassName AdminServiceTest
 * @Description 新增会员信息方法的测试类
 * @Author na.zhao
 * @Date 2021/4/21 10:50
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddUserMethodTests extends BaseTestNGTestCase {

    @Autowired
    MemberManageService memberManageService;

    @Autowired
    MemberManageController memberManageController;

    @Test
    public void testMapperStruct() {
        Account account = new Account();
        account.setUsername("na.zhao");
        account.setPassword("123456");
        AccountDto accountDto = DtoAndEntityConvertor.INSTANCE.entity2AccountDto(account);
        Assert.assertNotNull(accountDto);
        Assert.assertEquals(accountDto.getUserName(), account.getUsername());
        Assert.assertEquals(accountDto.getPassword(), account.getPassword());
    }

    @Test(description = "成功添加会员信息")
    public void testAddUserMethodCase00() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("Jianjuun");
        user.setPhoneNumber("5201");
        user.setGender(0);
        user.setCardType(CardTypeEnum.MONTH_CARD);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), "200");
        Assert.assertEquals(webResult.getMsg(), "新增会员信息成功！");
    }

    @Test(description = "必填项[姓名]为空")
    public void testAddUserMethodCase01() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setPhoneNumber("5201");
        user.setGender(0);
        user.setCardType(CardTypeEnum.SEASON_CARD);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), "-1");
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "必填项[性别]为空")
    public void testAddUserMethodCase02() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("赵娜");
        user.setPhoneNumber("5201");
        user.setCardType(CardTypeEnum.WEEK_CARD);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "必填项[卡类型]为空")
    public void testAddUserMethodCase03() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("赵娜");
        user.setPhoneNumber("5201");
        user.setGender(0);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "必填项[电话号码]为空")
    public void testAddUserMethodCase04() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("赵娜");
        user.setCardType(CardTypeEnum.WEEK_CARD);
        user.setGender(1);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "user==null")
    public void testAddUserMethodCase05() {
        AddUserInfoReq user = new AddUserInfoReq();
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "性别是除 0 1 以外的其他类型")
    public void testAddUserMethodCase06() throws Exception {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("赵娜nz");
        user.setGender(2);
        user.setPhoneNumber("2233333");
        user.setCardType(CardTypeEnum.MONTH_CARD);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

    @Test(description = "卡类型是除 0 1 2 3 以外的类型")
    public void testAddUserMethodCase07() {
        AddUserInfoReq user = new AddUserInfoReq();
        user.setName("赵娜nz");
        user.setGender(0);
        user.setPhoneNumber("2233333");
        user.setCardType(CardTypeEnum.MONTH_CARD);
        WebResult webResult = memberManageController.addUserInfo(user);
        Assert.assertEquals(webResult.getCode(), new Integer(-1));
        Assert.assertEquals(webResult.getMsg(), "新增会员信息失败，请联系系统管理员！");
    }

}
