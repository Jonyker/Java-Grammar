package com.wukj.thread.sync;

import java.lang.Thread;

public class ThreadSyncClass {

    /**
     * 基本上所有的并发模式在解决线程安全问题时，都采用“序列化访问临界资源”的方案，即在同一时刻，只能有一个线程访问临界资源，也称作同步互斥访问。
     * 通常来说，是在访问临界资源的代码前面加上一个锁，当访问完临界资源后释放锁，让其他线程继续访问。
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 每个类也会有一个锁，它可以用来控制对static数据成员的并发访问。
         * 
         * 并且如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static
         * synchronized方法，此时不会发生互斥现象，因为访问static synchronized方法占用的是类锁，而访问非static
         * synchronized方法占用的是对象锁，所以不存在互斥现象。
         * 
         */

        // 有一点要注意：对于synchronized方法或者synchronized代码块，当出现异常时，
        // JVM会自动释放当前线程占用的锁，因此不会由于异常导致出现死锁现象。
        final InsertData3 insertData = new InsertData3();
        new Thread(){
            @Override
            public void run() {
                insertData.insert();
            }
        }.start(); 
        new Thread(){
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();
    }

}

class InsertData3 {

    public synchronized void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public synchronized static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }

}
