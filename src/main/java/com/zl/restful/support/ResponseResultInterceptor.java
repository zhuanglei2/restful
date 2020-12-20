package com.zl.restful.support;

import com.zl.restful.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 3:06 下午
 * @Version 1.0
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor{
    public static final String RESPNSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> beanType = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            if(beanType.isAnnotationPresent(ResponseResult.class)){
                request.setAttribute(RESPNSE_RESULT_ANN,beanType.getAnnotation(ResponseResult.class));
            }else if(method.isAnnotationPresent(ResponseResult.class)){
                request.setAttribute(RESPNSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
