package com.example.demo;

import com.example.demo.entity.Coach;
import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyz.erupt.core.view.EruptModel;
import xyz.erupt.jpa.service.EruptDataServiceDbImpl;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.util.MD5Utils;

import java.time.LocalDate;
import java.util.Calendar;


/**
 * @ClassName AddUserTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/6 16:13
 */

@SpringBootTest
public class AddUserTest extends BaseTestNGTestCase {
    @Autowired
    CoachRepository coachRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EruptDataServiceDbImpl eruptDataServiceDb;

    @Test
    public void test() {
        Coach coach = coachRepository.findByName("索索");
        logger.info(coach.getCoachNumber() + "/////////////////////////*");
        Assert.assertEquals(coach.getCoachNumber(), "2021050659011276");
    }

    @Test(description = "测试添加账号")
    public void testAddAccount() {
        EruptUser user = new EruptUser();
        user.setAccount("pap");
        user.setPassword("123456");
        accountRepository.save(user);
    }

    @Test(description = "测试时间大小比较")
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now().plusDays(1L);
        int res = LocalDate.now().compareTo(localDate);
        logger.info(LocalDate.now() + "今天");
        logger.info(localDate + "，明天");
        logger.info(res + "////////////////////");
        Assert.assertEquals(res, 0);
    }


    @Test(description = "测试加密")
    public void testEnCrypt() {
        EruptUser user = new EruptUser();
        user.setAccount("222");
        String pwd = MD5Utils.digest("erupt");
        user.setPassword(pwd);
        accountRepository.save(user);
    }

    @Test(description = "测试添加用户显示超出数据库字段")
    public void case01(){
        User user = new User();
        user.setBeginTime(LocalDate.now().toString());
        user.setBeginTime(LocalDate.now().plusYears(1L).toString());
        user.setCardNum("123345");
        user.setCardType("年卡");
        user.setGender("nv");
        user.setMemberName("nv");
        user.setPhoneNumber("nv");
        EruptModel eruptModel = new EruptModel(User.class);
        eruptDataServiceDb.addData(eruptModel,user);
    }
}
