package com.wukj.thread.method;

import java.lang.Thread;
import java.lang.Runnable;

public class ThreadCreate {

	public static void main(String[] args) {
		System.out.println("主线程ID:" + Thread.currentThread().getId());
		/**
		 * 创建子线程的两种方式：
		 * 1.继承Thread类
		 * 2.实现Runnable接口
		 */
		ThreadA aa = new ThreadA();
		Thread bb = new Thread(new ThreadB());
		aa.start();
		bb.start();

	}

}

class ThreadA extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("子线程ID:" + Thread.currentThread().getId());
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		System.out.println("子线程ID:" + Thread.currentThread().getId());
	}
}