package com.wukj.aop.normal.intercepter;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 上午 11:32
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 上午 11:32
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class NormalInterceptor extends FyInterceptorAdapter {

    public NormalInterceptor() {

    }

    public NormalInterceptor(Class<?> klass, Method method) {
        super(klass, method);
    }

    @Override
    public boolean before(Object[] args) {
        System.out.println("-----setName：before");
        return super.before(args);
    }

    @Override
    public Object after(Object result) {
        System.out.println("-----setName：after");
        return super.after(result);
    }



}
