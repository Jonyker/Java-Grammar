package com.wukj.aop.full.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:02
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:02
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class Proxyfactory {
    private FyProxy fyProxy;

    public Proxyfactory() {
    }

    public FyProxy getFyProxy() {
        return fyProxy;
    }

    /**
     * Cglib方式构建代理
     * @param klass
     * @param object
     * @param <T>
     * @return
     */
    public <T> T getCglibProxy(Class<?> klass, Object object) {
        fyProxy = new FyProxy();
        T proxy = cglibProxy(klass, object);
        fyProxy.setProxy(proxy);
        fyProxy.setObject(object);
        return proxy;
    }

    @SuppressWarnings("unchecked")
    private <T> T cglibProxy(Class<?> klass, Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(klass);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                return doInvoker(klass, object, method, args);
            }
        });
        return (T) enhancer.create();
    }

    /**
     * JDK方式构建代理
     * @param klass
     * @param object
     * @param <T>
     * @return
     */
    public <T> T getJdkProxy(Class<?> klass, Object object) {
        fyProxy = new FyProxy();
        T proxy = jdkProxy(klass, object);
        fyProxy.setProxy(proxy);
        fyProxy.setObject(object);
        return proxy;
    }

    @SuppressWarnings("unchecked")
    private <T> T jdkProxy(Class<?> klass, Object object) {
        ClassLoader classLoader = klass.getClassLoader();
        Class<?>[] interfaces = klass.getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return doInvoker(klass, object, method, args);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private <T> T doInvoker(Class<?> klass, Object object, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (fyProxy.doBefore(klass, method, args)) {
            try {
                result = method.invoke(object, args);
                fyProxy.doAfter(klass, method, result);
            } catch (Throwable th) {
                fyProxy.doException(klass, method, th);
            }
        }
        return (T) result;
    }


}
