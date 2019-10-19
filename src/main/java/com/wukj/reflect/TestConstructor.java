package com.wukj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor {

	public static void main(String[] args) {
		//   Auto-generated method stub
		/**
		 * Constructor 同 Method 差不多，但是它特别的地方在于，它能够创建一个对象。
		 * 
		 * 在 Java 反射机制中有两种方法可以用来创建类的对象实例：Class.newInstance() 和 Constructor.newInstance()。官方文档建议开发者使用后面这种方法，下面是原因。
		 * 
		 * (1)Class.newInstance() 只能调用无参的构造方法，而 Constructor.newInstance() 则可以调用任意的构造方法。
		 * (2)Class.newInstance() 通过构造方法直接抛出异常，而 Constructor.newInstance() 会把抛出来的异常包装到 InvocationTargetException 里面去，这个和 Method 行为一致。
		 * (3)Class.newInstance() 要求构造方法能够被访问，而 Constructor.newInstance() 却能够访问 private 修饰的构造器。
		 */
		
		try {
			Class<D> cls = D.class;
			
			System.out.println("------------------------constructor");
			
			// (一)cls.newInstance
			D d = (D) cls.newInstance();
			
			// (二)constuctor.newInstance
			Constructor<D> constr = cls.getConstructor(String.class);
			D tom = constr.newInstance("tom");
			
		} catch (InstantiationException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
