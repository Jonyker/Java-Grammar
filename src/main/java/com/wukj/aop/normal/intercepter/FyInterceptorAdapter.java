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
 * 1.
 * 2.
 */
public class FyInterceptorAdapter extends FyInterceptor{
    
    public FyInterceptorAdapter() {
	}
 
	public FyInterceptorAdapter(Class<?> klass, Method method) {
		super(klass, method);
	}
 
	@Override
	public boolean before(Object[] args) {
		return true;
	}
 
	@Override
	public Object after(Object result) {
		return result;
	}
 
	@Override
	public void dealException(Throwable th) {
	}



}