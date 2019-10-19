package com.wukj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.wukj.reflect.D.Color;

public class TestEnum {

	public static void main(String[] args) {
		try {
			Class cls = StateEnum.class;
			System.out.println("------------------------enum");
			System.out.println("" + Arrays.asList(cls.getEnumConstants()));

			if (cls.isEnum()) {
				Field[] fields = cls.getDeclaredFields();
				for (Field field : fields) {
					System.out.println("---------------");
					if (field.isEnumConstant()) {
						System.out.println("is enum field:" + field.getName());
						System.out.println("is enum field:" + field.getType());
					} else {
						System.out.println("no enum field:" + field.getName());
						System.out.println("no enum field:" + field.getType());
					}
					System.out.println("");
				}
			}

			Class clz = D.class;
			Field f = clz.getDeclaredField("mColor");
			f.setAccessible(true);
			Constructor<D> constr = clz.getConstructor(null);
			D d = constr.newInstance(null);
			Color color1 = (Color) f.get(d);
			System.out.println("Color State:"+color1);
			f.set(d, Color.BLUE);
			Color color2 = (Color) f.get(d);
			System.out.println("Color State:"+color2);
		} catch (SecurityException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}

	}

}
