package com.zl.restful.support;

import com.zl.restful.common.ResponseResult;
import com.zl.restful.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 3:13 下午
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice {

    public static final String RESPNSE_RESULT_ANN = "RESPONSE_RESULT_ANN";


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求 示范有包装标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPNSE_RESULT_ANN);
        return responseResult!=null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("进入方法体 重写格式 处理中 。。。");
        if(o instanceof Result){
            Result result = (Result) o;
            if (result.isSuccessed()){
                return Result.success(o);
            }

            return Result.failure(result.getCode(),result.getMessage());
        }
        return Result.success(o);
    }
}
