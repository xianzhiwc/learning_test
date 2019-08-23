package com.learn.multithread;

public class Customer implements Runnable {
    private Resource rs;
    Customer(Resource rs){
        this.rs =rs;
    }
    @Override
    public void run() {
        for(int i = 0;i<10;i++)
            rs.sellout();
    }
}
