package com.vip.zn.fitness_system.exception;

import com.vip.zn.fitness_system.common.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description ControllerAdvice注解表示开启全局异常捕获
 * @Author na.zhao
 * @Date 2021/4/26 9:37
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public WebResult exceptionHanlder(HttpServletRequest req, BizException ex) {
        logger.error("发生业务异常！原因是：{}", ex.getErrorMsg());
        return WebResult.buildFail(ex.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public WebResult exceptionHandler(HttpServletRequest req, NullPointerException ex) {
        logger.error("发生空指针异常！原因是：", ex);
        return WebResult.buildFail(CommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WebResult exceptionHandler(HttpServletRequest req, Exception ex) {
        logger.error("未知异常，原因是：", ex);
        return WebResult.buildFail(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}













