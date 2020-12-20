package com.zl.restful.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 2:36 下午
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Result {
    private Integer code;

    private String message;

    private Object data;

    public Result(ResultCode resultCode,Object object){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = object;
    }

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static Result success(){
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object object){
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result success(ResultCode resultCode){
        Result result = new Result(resultCode);
        return result;
    }

    public static Result success(ResultCode resultCode,Object object){
        Result result = new Result(ResultCode.SUCCESS,object);
        return result;
    }

    public static Result failure(ResultCode resultCode,Object o){
        Result result = new Result(resultCode);
        result.setData(o);
        return result;
    }
    public static Result failure(Integer resultCode,String message){
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(message);
        return result;
    }


    public boolean isSuccessed(){
        return Objects.equals(this.code,ResultCode.SUCCESS.getCode());
    }
}
