package com.learn.multithread;

public class ProduceCustomDemo {
    public static void main(String[] args) {
        Resource rs = new Resource();
        Runnable pro = new Producer(rs);
        Runnable cst = new Customer(rs);
        Thread thPro1 = new Thread(pro);
        Thread thCst1 = new Thread(cst);
        Thread thPro2 = new Thread(pro);
        Thread thCst2 = new Thread(cst);
        thPro1.start();
        thCst1.start();
        thPro2.start();
        thCst2.start();

    }
}
