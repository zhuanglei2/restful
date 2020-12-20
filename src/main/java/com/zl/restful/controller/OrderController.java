package com.zl.restful.controller;

import com.zl.restful.common.ResponseResult;
import com.zl.restful.common.Result;
import com.zl.restful.common.ResultCode;
import com.zl.restful.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 2:49 下午
 * @Version 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("{id}")
    public Order getOrder(@PathVariable("id")Integer id){
        Order order = new Order();
        order.setOrderAmt("10");
        order.setOrderCode("234");
        return order;
    }
}
