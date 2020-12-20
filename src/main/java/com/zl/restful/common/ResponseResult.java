package com.zl.restful.common;

import java.lang.annotation.*;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 3:04 下午
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {

}
