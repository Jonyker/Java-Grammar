package com.wukj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethosInvoke {

	public static void main(String[] args) {
		
		
		Class cls;
		try {
			cls = Class.forName("com.wukj.reflect.D");
		
		/**
		 * 执行methos方法
		 * public Object invoke(Object obj, Object... args) {}
		 * 
		 * (1)invoke() 方法中第一个参数 Object 实质上是 Method 所依附的 Class 对应的类的实例，如果这个方法是一个静态方法，那么 ojb 为 null，后面的可变参数 Object 对应的自然就是参数。
		 * 
		 * (2)invoke() 返回的对象是 Object，所以实际上执行的时候要进行强制转换。
		 *
		 * (3)在对 Method 调用 invoke() 的时候，如果方法本身会抛出异常，那么这个异常就会经过包装，由 Method 统一抛出 InvocationTargetException。而通过 InvocationTargetException.getCause() 可以获取真正的异常。
		 */
		System.out.println("------------------------执行静态方法");
		// 执行静态clear的方法
		Method clearMethod = cls.getMethod("clear", Integer.TYPE);
		clearMethod.invoke(null, 5);
		
		System.out.println("------------------------执行私有带参数的方法");
		Method subMethod = cls.getDeclaredMethod("sub",int.class,int.class);
        // 通过这句代码才能访问 private 修饰的 Method
		subMethod.setAccessible(true);
        int result = (int) subMethod.invoke(cls.newInstance(), 1,2);
        System.out.println("add method result:"+result);
        
        System.out.println("------------------------执行向外抛出异常的方法");
		Method exceMethod = cls.getDeclaredMethod("add",Double.TYPE);
        exceMethod.invoke(cls.newInstance(), 5.0D);
		
		} catch (ClassNotFoundException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			//   Auto-generated catch block
			// e.printStackTrace();
			
			 // 通过 InvocationTargetException.getCause() 获取被包装的异常
            System.out.println("testException occur some error,Error type is :"+e.getCause().getClass().getName());
            System.out.println("Error message is :"+e.getCause().getMessage());

		} catch (InstantiationException e) {
			//   Auto-generated catch block
			e.printStackTrace();
		}
				
				
	}
	
	
	
	
}
