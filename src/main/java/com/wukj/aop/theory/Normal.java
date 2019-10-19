package com.wukj.aop.theory;

import com.wukj.aop.theory.anno.Before;
import com.wukj.aop.theory.entity.Order;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/19 0019 下午 1:55
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/19 0019 下午 1:55
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class Normal {


    @Before(property = "orderId")
    public void save(Order order) {
        System.out.println("----保存信息");
    }

}
