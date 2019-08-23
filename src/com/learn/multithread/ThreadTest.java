package com.learn.multithread;

/**
 * Thread sleep和wait区别
 *
 * @author DreamSea
 * 2012-1-15
 */
public class ThreadTest implements Runnable {
    int number = 10;

    public void firstMethod() throws Exception {
        synchronized (this) {
            number += 100;
            this.wait();
            System.out.println("first:"+number);
        }
    }

    public void secondMethod() throws Exception {
        synchronized (this) {
            /**
             * (休息2S,阻塞线程)
             * 以验证当前线程对象的机锁被占用时,
             * 是否被可以访问其他同步代码块
             */
            Thread.sleep(200);
            //this.wait(2000);
            number *= 200;
            System.out.println("sencond:"+number);
        }
    }

    @Override
    public void run() {
        try {
            firstMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public static Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) {
                System.out.println(t.getName());
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        for (int i=0;i<10;i++){
            System.out.println("第"+i+"次执行：");
            ThreadTest threadTest = new ThreadTest();
            Thread thread = new Thread(threadTest);
            thread.setName("thread"+i);
            thread.start();
            threadTest.secondMethod();
        }
        for(int j = 0 ; j<10;j++){
            String threadName = "thread"+j;
            Thread currThread = ThreadTest.getThreadByName(threadName);
            synchronized (currThread){
                currThread.notify();
            }
        }
    }
}

