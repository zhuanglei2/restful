package com.zl.restful.config;

import com.zl.restful.support.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 3:31 下午
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInterceptor);
    }
}
