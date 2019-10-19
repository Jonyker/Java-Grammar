package com.wukj.thread.method;

import java.lang.Thread;

public class ThreadSleep{

    private int i = 0;
	// 特殊的instance变量
    private byte[] lock = new byte[0];
    
    public static void main(String[] args) {
        ThreadSleep state = new ThreadSleep();
        // sleep
		CustomThread sleepA = state.new CustomThread();
		CustomThread sleepB = state.new CustomThread();
		sleepA.start();
        sleepB.start();
        
    }


    class CustomThread extends Thread {
		@Override
		public void run() {
			super.run();
			synchronized (lock) {
				i++;
				System.out.println("i:" + i);
				try {
					System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
				i++;
				System.out.println("i:" + i);
			}
		}
	}
}