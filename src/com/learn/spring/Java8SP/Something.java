package com.learn.spring.Java8SP;

public class Something {
    public  Something (){};
    public  Something (String s){
        System.out.println(s);
    };
    static String starsWith (String s){
        return  String.valueOf(s.charAt(0));
    }

    static String endWith (String s){

        return  String.valueOf(s.charAt(s.length()-1));
    }
}
