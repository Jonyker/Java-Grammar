package com.wukj.aop.normal.intercepter;


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
 * 1.拦截器的抽象方法
 * 2.前置拦截是对参数的操作，返回值boolean类型决定是否继续运行；而后置或滞后拦截是对反射机制执行后结果的操作
 */
public abstract class FyInterceptor{
    private Class<?> klass;
	private Method method;
 
	public FyInterceptor() {
	}
	
	public FyInterceptor(Class<?> klass, Method method) {
		this.klass = klass;
		this.method = method;
	}
	
	public void setKlass(Class<?> klass) {
		this.klass = klass;
	}
	
	public void setMethod(Method method) {
		this.method = method;
	}
	
	public Class<?> getKlass() {
		return klass;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public abstract boolean before(Object[] args);
	public abstract Object after(Object result);
	public abstract void dealException(Throwable th);

}


