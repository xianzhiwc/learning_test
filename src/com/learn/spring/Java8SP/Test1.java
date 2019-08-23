package com.learn.spring.Java8SP;

import java.util.Spliterator;

public class Test1 {
    public static void main(String[] args) {
        FunctionalIter<String,String> fun = Something::starsWith;
        String s =fun.func("12345");
        System.out.println(s);
    }
}
