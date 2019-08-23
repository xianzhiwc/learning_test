package com.learn.spring.Java8SP;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        for (Integer n : list){
//            System.out.println(n*n);
//        }

//        list.forEach(n -> System.out.println(n*n));
        //  list.forEach(System.out::println);
          Consumer<Integer> con = System.out::println;
          list.forEach(n -> con.accept(n));
          //list.stream().map(n->n*n).forEach(System.out::println);

    }
}
