package com.learn.multithread;

import java.util.concurrent.Callable;

public class SomeCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0;i<10;i++){
            System.out.println("thread3:"+i);
        }
        return null;
    }
}
