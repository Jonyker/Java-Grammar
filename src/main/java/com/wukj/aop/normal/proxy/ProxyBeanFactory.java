package com.wukj.aop.normal.proxy;

import java.util.HashMap;
import java.util.Map;

import com.wukj.aop.normal.exception.InterceptorAlreadyExistException;
import com.wukj.aop.normal.intercepter.FyInterceptorAdapter;

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
public class ProxyBeanFactory {

    private static final Map<String, FyProxy> beanMap = new HashMap<>();

    public ProxyBeanFactory() {
    }

    @SuppressWarnings("unchecked")
    public <T> T creatCglibProxy(Object object) {
        Object proxy = cglibProxy(object.getClass(), object);
        return (T) proxy;
    }

    @SuppressWarnings("unchecked")
    public <T> T creatCglibProxy(Class<?> klass) throws InstantiationException, IllegalAccessException {
        Object proxy = cglibProxy(klass, klass.newInstance());
        return (T) proxy;
    }

    @SuppressWarnings("unchecked")
    public <T> T creatJdkProxy(Class<?> klass) throws InstantiationException, IllegalAccessException {
        Object proxy = jdkProxy(klass, klass.newInstance());
        return (T) proxy;
    }

    @SuppressWarnings("unchecked")
    public <T> T creatJdkProxy(Object object) {
        Object proxy = jdkProxy(object.getClass(), object);
        return (T) proxy;
    }

    // 这个类的核心在这里！！
    // 对外
    // 通过类或者对象获得代理对象（look上面！）
    // 并将其加到Map集合里
    // 所以现在的Map集合中放入的是每个类和与之对应的Fyproxy（代理对象，原对象，拦截器链）
    // 有了这个Map，外面就可以通过Map得到一系列的操作了
    // 当然下面CGLIB和这个一样啦，毕竟提供了两种代理方式啦
    @SuppressWarnings("unchecked")
    private <T> T jdkProxy(Class<?> klass, Object object) {
        String className = klass.getName();
        FyProxy fyProxy = beanMap.get(className);
        if (fyProxy != null) {
            return (T) fyProxy.getProxy();
        }

        ProxyFactory proxyFactory = new ProxyFactory();
        T proxy = proxyFactory.getJdkProxy(klass, object);
        beanMap.put(className, proxyFactory.getFyProxy());
        return proxy;
    }

    @SuppressWarnings("unchecked")
    private <T> T cglibProxy(Class<?> klass, Object object) {
        String className = klass.getName();
        FyProxy fyProxy = beanMap.get(className);
        if (fyProxy != null) {
            return (T) fyProxy.getProxy();
        }

        ProxyFactory proxyFactory = new ProxyFactory();
        T proxy = proxyFactory.getCglibProxy(klass, object);
        beanMap.put(className, proxyFactory.getFyProxy());
        return proxy;
    }

    // 这里是面向使用者
    // 对某类添加拦截器
    public void addInterceptor(Class<?> klass, FyInterceptorAdapter interceptor)
            throws InterceptorAlreadyExistException {
        if (!interceptor.getKlass().equals(klass)) {
            return;
        }
        beanMap.get(klass.getName()).addInterceptor(interceptor);
    }

    public void removeInterceptor(Class<?> klass, FyInterceptorAdapter interceptor) {
        if (!interceptor.getKlass().equals(klass)) {
            return;
        }
        beanMap.get(klass.getName()).removeInterceptor(interceptor);
    }
}
