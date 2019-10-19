package com.wukj.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class TestArray {

	public static void main(String[] args) {
		try {
			Class<?> cls = D.class;
			System.out.println("------------------------array");
			Field field = cls.getDeclaredField("nums");
			Class<?> c = field.getType();
			if(c.isArray()) {
				System.out.println("getName："+c.getName());
				System.out.println("getComponentType："+c.getComponentType());
			}
			D d = (D) cls.newInstance();
			Object obj = Array.newInstance(int.class, 3);
			Array.set(obj, 0, 41);
			Array.set(obj, 1, 53);
			Array.set(obj, 2, 49);
			
			field.set(d, obj);
			
			int[] array = d.getNums();
			for (int i : array) {
				System.out.println("i："+i);
			}
			
			
		} catch (SecurityException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
