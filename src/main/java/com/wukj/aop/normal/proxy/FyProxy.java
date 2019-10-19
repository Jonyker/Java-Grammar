package com.wukj.aop.normal.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
public class FyProxy{
    
    private Object proxy;
	private Object object;
	private List<FyInterceptorAdapter> interceptorList;
	
	public FyProxy() {
		interceptorList = new ArrayList<>();
	}
 
	public Object getProxy() {
		return proxy;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
 
	public List<FyInterceptorAdapter> getInterceptorList() {
		return interceptorList;
	}
	
	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
 
	public void setInterceptorList(List<FyInterceptorAdapter> interceptorList) {
		this.interceptorList = interceptorList;
	}
 
        // 执行前置拦截的方法
        // 通过参数决定是否执行该拦截器的前置拦截
	public boolean doBefore(Method method, Object[] args) {
		for (FyInterceptorAdapter interceptor : interceptorList) {
			if (!interceptor.getMethod().equals(method)) {
				continue;
			}
			if (!interceptor.before(args)) {
				return false;
			}
		}
		return true;
	}
	
        // 后置拦截
	public Object doAfter(Method method, Object result) {
		for (FyInterceptorAdapter interceptor : interceptorList) {
			if (!interceptor.getMethod().equals(method)) {
				continue;
			}
			return interceptor.after(result);
		}
		return result;
	}
	
        // 异常拦截
	public void doDealException(Method method, Throwable th) throws Throwable {
		for (FyInterceptorAdapter interceptor : interceptorList) {
			if (!interceptor.getMethod().equals(method)) {
				continue;
			}
			interceptor.dealException(th);
			throw th;
		}
	}
	
    // 当该类拦截器存在时无法添加新拦截器
    // 这里会抛出一个自定义异常
	public void addInterceptor(FyInterceptorAdapter interceptor) throws InterceptorAlreadyExistException {
		String interceptorName = interceptor.getClass().getName();
		if (interceptorList.contains(interceptor)) {
			throw new InterceptorAlreadyExistException("拦截器" + interceptorName +"已存在");
		}
		interceptorList.add(interceptor);
	}
	
        // 删除拦截器
	public void removeInterceptor(FyInterceptorAdapter interceptor) {
		if (!interceptorList.contains(interceptor)) {
			return;
		}
		interceptorList.remove(interceptor);
    }

}