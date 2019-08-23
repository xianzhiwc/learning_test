package com.learn.spring.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
     Runnable runTest = new ThreadTest();
     Thread  thread = new Thread(runTest);
     thread.start();
     //thread.sleep(1);
        // thread.wait();
     for (int i=10;i<20;i++){
         System.out.println(i);
     }
    }
}
