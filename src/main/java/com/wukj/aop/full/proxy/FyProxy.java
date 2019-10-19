package com.wukj.aop.full.proxy;

import com.wukj.aop.full.intercepter.InterceptorFactory;
import com.wukj.aop.full.intercepter.InterceptorMethodDefination;
import com.wukj.aop.full.intercepter.InterceptorTargetDefination;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 6:57
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 6:57
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class FyProxy {
    private Object proxy;               // 代理对象
    private Object object;              // 原对象
    private boolean injection;          // 是否已经注入

    public FyProxy() {                  // 构造方法
        injection = false;              // 没有注入
    }

    // 这是代理对象执行方法时会调用的前置拦截器
    // 根据传递过来的类和方法从InterceptorFactory中找到前置拦截器链
    // 遍历拦截器链，实现方法，返回result
    public boolean doBefore(Class<?> klass, Method method, Object[] args) {
        List<InterceptorMethodDefination> list =
                InterceptorFactory.getBeforeInterceptorList(new InterceptorTargetDefination(klass, method));
        if (list == null) {
            return true;
        }
        for (InterceptorMethodDefination interceptor : list) {
            Method interceptorMethod = interceptor.getMethod();
            Object interceptorObject = interceptor.getObject();
            boolean result = false;

            try {
                result = (Boolean) interceptorMethod.invoke(interceptorObject,args);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result == false) {
                return false;
            }
        }
        return true;
    }

    public boolean doAfter(Class<?> klass, Method method, Object args) {

        return true;
    }

    public boolean doException(Class<?> klass, Method method, Object args) {

        return true;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isInjection() {
        return injection;
    }

    public void setInjection(boolean injection) {
        this.injection = injection;
    }
}
