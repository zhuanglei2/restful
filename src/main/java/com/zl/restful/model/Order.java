package com.zl.restful.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author zhuanglei
 * @Date 2020/12/20 2:51 下午
 * @Version 1.0
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1655817672732068250L;
    private String orderCode;
    private String orderAmt;
}
