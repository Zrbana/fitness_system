package com.vip.zn.fitness_system.common;

import com.alibaba.fastjson.JSON;
import com.vip.zn.fitness_system.exception.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName WebResult
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/16 9:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResult {
    /**
     * 成功状态码
     */
    public static final String CODE_SUC = "200";

    /**
     * 失败状态码
     */
    public static final String CODE_FAIL = "-1";

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 结果编码
     */
    private String code;

    /**
     * 数据
     */
    private Object data;

    public WebResult(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public static WebResult buildFail(CommonEnum bodyNotMatch) {
        return new WebResult(null, CODE_FAIL, bodyNotMatch.getResultMsg());
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static WebResult buildSucc(String msg) {
        return new WebResult(msg, CODE_SUC, "成功");
    }

    public static WebResult buildSucc(Object data) {
        return new WebResult("成功", CODE_SUC, data);
    }

    public static WebResult buildSucc(String msg, String code) {
        return new WebResult(msg, "200");
    }

    public static WebResult buildSucc(String msg, String code, Object data) {
        return new WebResult(msg, code, data);
    }

    public static WebResult buildFail(String msg) {
        return new WebResult(null, CODE_FAIL, msg);
    }

    public static WebResult buildFail(String msg, String code, Object data) {
        return new WebResult(msg, CODE_FAIL, null);
    }

    public static WebResult buildFail(String msg, String code) {
        return new WebResult(msg, CODE_FAIL);
    }
}
