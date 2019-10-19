package com.wukj.aop.theory.entity;

import java.io.Serializable;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/19 0019 下午 1:56
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/19 0019 下午 1:56
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
