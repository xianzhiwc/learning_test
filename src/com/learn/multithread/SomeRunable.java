package com.learn.multithread;

public class SomeRunable implements  Runnable {
    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("thread2:"+i);
        }
    }


}
