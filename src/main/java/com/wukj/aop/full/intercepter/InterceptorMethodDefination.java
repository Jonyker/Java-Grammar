package com.wukj.aop.full.intercepter;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:00
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:00
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class InterceptorMethodDefination {
    private Class<?> klass;
    private Method method;
    private Object object;

    public InterceptorMethodDefination(Class<?> klass, Method method, Object object) {
        this.klass = klass;
        this.method = method;
        this.object = object;
    }

    // 我们要拦截，当然只需知道我们拦截的是哪个类的哪个方法就行了

    // 当然下面还有equals方法


    public Class<?> getKlass() {
        return klass;
    }

    public void setKlass(Class<?> klass) {
        this.klass = klass;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
