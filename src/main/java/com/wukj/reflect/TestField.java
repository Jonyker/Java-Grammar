package com.wukj.reflect;

import java.lang.reflect.Field;

public class TestField {

	
	public static void main(String[] args) {

		/**
		 * 通过反射获取类的属性，然后对类的属性进行操作
		 */
		System.out.println("------------------------field");
		Class<D> clazz = D.class;
		// 获取指定的属性
		try {
			D d = (D) clazz.newInstance();
			Field field = clazz.getField("km");
			Field desField = clazz.getDeclaredField("des");
			System.out.println("getName：" + field.getName());
			System.out.println("getModifiers：" + field.getModifiers());
			System.out.println("getInt：" + field.getInt(d));
			field.setInt(d, 5);
			System.out.println("getInt：" + field.getInt(d));

			// 被private修饰的属性，需要设置setAccessible(true)，才能被访问。
			desField.setAccessible(true);
			desField.set(d, "this is dog");
			System.out.println("get：" + desField.get(d));

		} catch (NoSuchFieldException | SecurityException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
