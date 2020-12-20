package com.zl.restful.common;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 2:31 下午
 * @Version 1.0
 */
public enum ResultCode {
    /* 成功状态*/
    SUCCESS(1,"成功"),
    /* 参数错误：1001-1999*/
    PARA_IS_INVALID(1001,"参数无效"),
    /*用户错误*/
    USER_NOT_LOGGED_IN(2001,"用户未登录")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
