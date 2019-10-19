package com.wukj.aop.full.bean;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:19
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:19
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class BeanMethodDefination {
    private Method method;
    private Object object;
    private Class<?> returnType;
    private Parameter[] parameters;
    private String beanName;

    public BeanMethodDefination() {
    }

    public BeanMethodDefination(Method method, Object object, Class<?> returnType, Parameter[] parameters, String beanName) {
        this.method = method;
        this.object = object;
        this.returnType = returnType;
        this.parameters = parameters;
        this.beanName = beanName;
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

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
