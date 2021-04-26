package com.vip.zn.fitness_system.utils;

import java.util.Random;

/**
 * @ClassName FitnessDefaultUtils
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 22:31
 */


public class FitnessDefaultUtils {

    private static int MIN = 10000000;
    private static int MAX = 99999999;

    /**
     * 生成默认账号
     *
     * @param
     * @return
     */
    public static String randomCardNum(String prefix) {
        return prefix + generateCode();
    }

    /**
     * 生成8位随机数
     *
     * @return
     */
    public static synchronized int generateCode() {
        Random random = new Random();
        return random.nextInt(MAX) % (MAX - MIN + 1) + MIN;
    }

}
