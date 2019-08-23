package com.learn.multithread;

public class Producer implements Runnable {
    private Resource rs;
    Producer(Resource rs){
        this.rs= rs;
    }
    @Override
    public void run() {
        for(int i = 0;i<10;i++)
            rs.setin("商品");
    }
}
