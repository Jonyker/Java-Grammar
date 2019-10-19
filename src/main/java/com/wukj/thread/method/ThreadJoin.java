package com.wukj.thread.method;

import java.lang.Thread;

public class ThreadJoin {

    
    public static void main(String[] args) {
        ThreadJoin state = new ThreadJoin();
        // join
        CustomThread joinA = state.new CustomThread();
        joinA.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            joinA.join();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class CustomThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }
}