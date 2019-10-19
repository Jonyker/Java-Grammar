package com.wukj.aop.full.intercepter;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:01
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:01
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class InterceptorTargetDefination {
    private Class<?> klass;
    private Method method;

    public InterceptorTargetDefination(Class<?> klass, Method method) {
        this.klass = klass;
        this.method = method;
    }

    private Object object;

    // 身为拦截器：我们当然要执行，通过反射机制，所以object必不可少

    // 构造方法

    // get和set方法


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
