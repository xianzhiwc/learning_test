package com.learn.multithread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    @Test
    public void someThread() throws InterruptedException {
        SomeThread someThread1 = new SomeThread();
        SomeThread someThread2 = new SomeThread();
        someThread1.start();
        someThread2.sleep(10000);
        someThread2.setDaemon(true);
        someThread2.start();
        someThread1.join();
        someThread2.join();
    }

    @Test
    public  void someRunable() throws InterruptedException {
        Runnable someRunable = new SomeRunable();
        Thread someThread = new Thread(someRunable);
        someThread.start();
        someThread.join();
        synchronized (this){
            wait(5000);
            notify();
        }
    }
    @Test
    public  void someCallable() throws InterruptedException {
        Callable someCallable = new SomeCallable();
        FutureTask future = new FutureTask(someCallable);
        Thread someThread = new Thread(future);
        someThread.start();
    }
    @Test
    public void testLock() throws InterruptedException {
         CountDownLatch latch = new CountDownLatch(5);
         Lock lock = new ReentrantLock(true);
         for (int i=0;i<5;i++)
         {
             new Thread(()->{
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 for (int j=0;j<5;j++){
                     lock.lock();
                     System.out.println(Thread.currentThread().getName()+"获得锁的线程:"+j);
                     lock.unlock();
                 }
             }).start();
         }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SomeThread someThread = new SomeThread();
        someThread.setDaemon(true);
        someThread.start();
        for (int i = 0;i<3;i++){
            int finalI = i;
            new Thread(()-> {
                for (int j = 0;j<5;j++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread"+ finalI +":"+j);
                }
            }
            ).start();
        }
    }
}
