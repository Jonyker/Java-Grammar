package com.wukj.aop.normal;

import com.wukj.aop.normal.exception.InterceptorAlreadyExistException;
import com.wukj.aop.normal.intercepter.NormalInterceptor;
import com.wukj.aop.normal.proxy.ProxyBeanFactory;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 6:05
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 6:05
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class Todo {


    public static void main(String[] args)
            throws NoSuchMethodException, SecurityException, InterceptorAlreadyExistException {

        // 根据某类某方法生成一个拦截器
        // 这里的拦截器interceptor是继承FyInterceptorAdapter重写的
        Class<?> klass = NormalClass.class;
        Method method = klass.getDeclaredMethod("setName", new Class<?>[] { String.class });
        NormalInterceptor interceptor = new NormalInterceptor(klass, method);

        // 创建代理对象
        // 添加拦截器
        // 用代理对象执行方法（代理对象内部调用方法还是利用原对象经反射机制实现，但代理对象执方法的同时会执行拦截器）拦截器工作！
        ProxyBeanFactory beanFactory = new ProxyBeanFactory();
        try {

            NormalClass object = beanFactory.creatCglibProxy(NormalClass.class);
            beanFactory.addInterceptor(klass, interceptor);

            object.setName("Jonyker");

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
