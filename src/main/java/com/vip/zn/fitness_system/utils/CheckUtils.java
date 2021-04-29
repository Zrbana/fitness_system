package com.vip.zn.fitness_system.utils;

import com.vip.zn.fitness_system.exception.BizException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName CheckUtils
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 20:26
 */


public final class CheckUtils {
    /**
     * if trueFlag != true, throw errMsg runtime exception
     */
    public static void assertTrue(boolean trueFlag, String errMsg) {
        if (!trueFlag) {
            throw new BizException(errMsg);
        }
    }

    /**
     * if falseFlag == true, throw errMsg runtime exception
     */
    public static void assertFalse(boolean falseFlag, String errMsg) {
        if (falseFlag) {
            throw new BizException(errMsg);
        }
    }

    /**
     * 判断 objA是否和objB相等,如果不相等,抛出errorMsg
     *
     * @param <T>
     **/
    public static <T> void assertEquals(T objA, T objB, String errMsg) {
        if (!(objA == null ? objB == null : objA.equals(objB))) {
            throw new BizException(errMsg);
        }
    }

    /**
     * 判断 objA是否和objB相等,如果不相等,抛出errorMsg
     *
     * @param
     **/
    public static void assertStrEquals(String strA, String strB, String errMsg) {
        if (!StringUtils.trimToEmpty(strA).equalsIgnoreCase(StringUtils.trimToEmpty(strB))) {
            throw new BizException(errMsg);
        }
    }

    /**
     * 判断values是否符合matcher 规则
     **/
    public static <P> void assertItemMatch(Consumer<P> matcher, List<P> values, String errMsg) {
        assertFalse(CollectionUtils.isEmpty(values), errMsg);
        try {
            values.forEach(matcher);
        } catch (Exception e) {
            throw new BizException(errMsg);
        }
    }

}
