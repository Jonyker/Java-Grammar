package com.wukj.thread.sync;

import java.lang.Thread;

public class ThreadSyncObject {

    public static void main(String[] args) {
        ThreadSyn threadSynOne = new ThreadSyn();
        Thread thread1 = new Thread(threadSynOne, "ThreadSynOne");
        Thread thread2 = new Thread(threadSynOne, "ThreadSynTwo");
        thread1.start();
        thread2.start();
/**
 * 结论：当两个并发线程(thread1和thread2)访问同一个对象（这个很重要）(ThreadSyn)中的synchronized代码块时，在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * hread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象，一个对象就一个锁。
 */

    }

}

/**
 * 线程代码块同步
 */
class ThreadSyn implements Runnable {
    private volatile static int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
