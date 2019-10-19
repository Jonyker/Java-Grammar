package com.wukj.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import com.wukj.reflect.animation.LogTarget;

public class TestMethod {

	public static void main(String[] args) {
		/**
		 * 方法由下面几个要素构成： 
		 * - 方法名 
		 * - 方法参数 
		 * - 方法返回值 
		 * - 方法的修饰符 
		 * - 方法可能会抛出的异常
		 */
		try {
			Class<?> cls = Class.forName("com.wukj.reflect.D");
			System.out.println("------------------------method");
			Method[] methods = cls.getDeclaredMethods();
			for (Method method : methods) {
				
				System.out.println("------------------------------------------------getName：" + method.getName());
				System.out.println("------------------------method-annotation-parameter");
				LogTarget logTarget = method.getAnnotation(LogTarget.class);
				if(logTarget != null){
					// 获取注解中的参数
					int code = logTarget.requestCode();
					System.out.println("code:"+code);
				}

				System.out.println("------------------------------------------------getName：" + method.getName());
				System.out.println("------------------------method-parameter-name");
				Parameter[] parameters = method.getParameters();
				for (Parameter param : parameters) {
					System.out.println("getName：" + param.getName() + " ---getType：" + param.getType().getName());
				}
				
				System.out.println("------------------------method-parameter-type");
				Class<?>[] pTypes = method.getParameterTypes();
				for (Class<?> clz : pTypes) {
					System.out.println("getName：" + clz.getName());
				}
				
				System.out.println("------------------------method-parameter-generic-type");
				Type[] gTypes = method.getGenericParameterTypes();
	            for ( Type type : gTypes ) {
	                System.out.println("getTypeName："+ type.getTypeName());
	            }
	            
	            System.out.println("------------------------method-parameter-return-type");
				Class<?> rType = method.getReturnType();
				System.out.println("getName："+ rType.getName());
				System.out.println("getTypeName："+ rType.getTypeName());
				System.out.println("getSimpleName："+ rType.getSimpleName());
	            
				
				System.out.println("------------------------method-parameter-return-generic-type");
				Type rnType = method.getGenericReturnType();
				System.out.println("getTypeName："+ rnType.getTypeName());
				
				
				System.out.println("------------------------method-exception");
				Class<?>[] exceCls = method.getExceptionTypes();
				for (Class<?> clz : exceCls) {
					System.out.println("getName："+ clz.getName());
					System.out.println("getTypeName："+ clz.getTypeName());
					System.out.println("getSimpleName："+ clz.getSimpleName());
				}
				
				System.out.println("------------------------method-exception-generic");
				Type[] exceTypes = method.getGenericExceptionTypes();
				for (Type type : exceTypes) {
					System.out.println("getTypeName："+ type.getTypeName());
				}
				
			}

		} catch (ClassNotFoundException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}

	}

}
