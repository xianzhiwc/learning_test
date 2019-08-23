package com.learn.multithread;

class Resource {
    private String name;  //货物名称
    private int count = 1;  //货物数量
    private boolean flag = false;  //是否有货

    public synchronized void setin(String name) {
        while (flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "--生产者--" + this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void sellout() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "--消费者--" + this.name);
        flag = false;
        this.notifyAll();
    }
}
