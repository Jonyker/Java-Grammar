package com.wukj.thread.sync;

import java.lang.Thread;
import java.util.ArrayList;

public class ThreadSyncBlock{

    
    public static void main(String[] args) {
        final InsertData2 insertData = new InsertData2();
         
        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();

        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            };
        }.start();
    }

}

class InsertData2 {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    /**
     * synchronized同步方法可以能会影响程序执行的效率，使用同步代码块会避免这个问题
     * @param thread
     */ 
    public void insert(Thread thread){
        synchronized (this) {
            for(int i=0;i<10;i++){
                System.out.println(thread.getName()+"在插入数据"+i);
                arrayList.add(i);
            }
        }
    }
    
}