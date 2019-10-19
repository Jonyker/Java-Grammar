package com.wukj.aop.normal.proxy;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/8/17 14:25
 * 作者：Jonyker
 * 博客：http://www.udevtech.com/
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/8/17 14:25
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 */
public class ProxyFactory {
    private FyProxy fyProxy;

    public ProxyFactory() {
    }

    public FyProxy getFyProxy() {
        return fyProxy;
    }

    // 这里着重说这个方法：
    // 用来给上层调用
    // 每通过原类和对象，get到一个代理对象的时候，
    // 新建一个FyProxy对象，并将其原对象和生成的代理对象set进这个fyProxy
    // 达到代理对象和原对象的一一对应关系
    // 将原对象set进去
    // 为后面完成IOC加上去的。。。
    @SuppressWarnings("unchecked")
    public <T> T getCglibProxy(Class<?> klass, Object object) {
        fyProxy = new FyProxy();
        Object proxy = cglibProxy(klass, object);
        fyProxy.setProxy(proxy);
        fyProxy.setObject(object);
        return (T) proxy;
    }

    @SuppressWarnings("unchecked")
    private <T> T cglibProxy(Class<?> klass, Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(klass);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                return doInvoker(object, method, args);
            }
        });
        return (T) enhancer.create();
    }

    @SuppressWarnings("unchecked")
    public <T> T getJdkProxy(Class<?> klass, Object object) {
        fyProxy = new FyProxy();
        Object proxy = jdkProxy(klass, object);
        fyProxy.setProxy(proxy);
        fyProxy.setObject(object);
        return (T) proxy;
    }

    @SuppressWarnings("unchecked")
    private <T> T jdkProxy(Class<?> klass, Object object) {
        ClassLoader classLoader = klass.getClassLoader();
        Class<?>[] interfaces = klass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return doInvoker(object, method, args);
            }
        });
    }


    // 看！！这个方法是代理对象执行方法时内部的“东西”
    // 各种拦截
    // 最中间调用方法的object是原对象！
    @SuppressWarnings("unchecked")
    private <T> T doInvoker(Object object, Method method, Object[] args) throws Throwable {
        Object result = null;

        fyProxy.doBefore(method, args);
        try {
            result = method.invoke(object, args);
            fyProxy.doAfter(method, result);
        } catch (Throwable th) {
            fyProxy.doDealException(method, th);
        }
        return (T) result;
    }

}