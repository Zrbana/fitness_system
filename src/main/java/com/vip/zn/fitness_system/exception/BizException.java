package com.vip.zn.fitness_system.exception;

import lombok.Data;

/**
 * @ClassName BizException
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/25 20:28
 */

@Data
public class BizException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    protected String errorCode;
    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(BaseErrorInfoInterface baseErrorInfoInterface){
        super(baseErrorInfoInterface.getResultCode());
        this.errorCode =  baseErrorInfoInterface.getResultCode();
        this.errorMsg = baseErrorInfoInterface.getResultMsg();
    }
    public BizException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode(), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }
    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg =errorMsg;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
