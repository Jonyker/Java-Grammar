package com.wukj.thread.method;

import java.lang.Thread;

public class ThreadInterrupt {

    
    public static void main(String[] args) {
        ThreadInterrupt state = new ThreadInterrupt();
        // interrupt
		CustomThread interruptA = state.new CustomThread();
		interruptA.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		interruptA.interrupt();

    }

    class CustomThread extends Thread {

        @Override
        public void run() {
            super.run();
			try {
				System.out.println("进入睡眠状态");
				Thread.sleep(10000);
				System.out.println("睡眠完毕");
			} catch (InterruptedException e) {
				System.out.println("得到中断异常");
			}
			System.out.println("run方法执行完毕");
        }
    }

    class CustomThread2 extends Thread {

        @Override
        public void run() {
            super.run();
			int i = 0;
            while(!isInterrupted() && i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }

    }

    class CustomThread3 extends Thread {

        private volatile boolean isStop = false;
        
        @Override
        public void run() {
            super.run();
			int i = 0;
            while(!isStop){
                i++;
            }
            System.out.println("i"+i);
        }

        public void setStop(boolean stop){
            this.isStop = stop;
        }
    }
}