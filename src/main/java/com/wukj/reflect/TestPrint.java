package com.wukj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPrint {

	public static void main(String[] args) {

		// 获取Class的三种对象方式
		D d = new D();
		Class<?> clazz1 = d.getClass();
		Class<?> clazz2 = D.class;

		try {
			Class<?> clazz3 = Class.forName("com.wukj.reflect.D");
		} catch (ClassNotFoundException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------------------declared-field");
		// 获取所有的属性，但不包括从父类继承下来的属性
		Field[] declaredFields = clazz1.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			System.out.println("getName:" + declaredFields[i].getName());
			System.out.println("modify:" + declaredFields[i].getModifiers());
		}

		System.out.println("------------------------field");
		// 获取自身的所有的 public 属性，包括从父类继承下来的。
		Field[] fields = clazz1.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("getName:" + fields[i].getName());
		}

		System.out.println("------------------------declared-method");
		// 获取method,但是不包括继承下来的method
		Method[] methods = clazz1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("getName：" + method.getName());
		}

		System.out.println("------------------------method");
		// 获取method，包括从父类继承的method
		Method[] desMethods = clazz1.getMethods();
		for (Method method : desMethods) {
			System.out.println("getName：" + method.getName());
		}

		System.out.println("------------------------constructor");
		// 获取类的构造
		Constructor[] constructors = clazz1.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("getName：" + constructor.getName());
		}
		
		System.out.println("------------------------generic");
		// 泛型属性
		Field[] fileds = clazz1.getFields();
		for (Field f : fileds) {
			System.out.println("getName：" + f.getName());
			System.out.println("getType：" + f.getType());
			System.out.println("getGenericType：" + f.getGenericType());
		}

	}

}
