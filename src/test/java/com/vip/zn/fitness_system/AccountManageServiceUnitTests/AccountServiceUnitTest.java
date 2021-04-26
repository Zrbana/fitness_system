package com.vip.zn.fitness_system.AccountManageServiceUnitTests;

import com.vip.zn.fitness_system.BaseTestNGTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * @ClassName AccountServiceUnitTest
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 23:11
 */

@SpringBootTest
public class AccountServiceUnitTest extends BaseTestNGTestCase {
    @Test(description = "账号或密码为空")
    public void testLoginCase01() {

    }

    @Test(description = "账号不存在")
    public void testLoginCase02() {

    }

    @Test(description = "账号密码不匹配")
    public void testLoginCase03() {

    }

    @Test(description = "账号已在其他地方登陆")
    public void testLoginCase04() {

    }

    @Test(description = "正常退出登陆")
    public void testLogoutCase01() {

    }
}
