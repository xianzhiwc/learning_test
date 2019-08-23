package com.learn.spring.demo2;

import java.lang.reflect.Proxy;

public class Test1 {
    public static void main(String[] args1) {
        Prophet ph = new Prophet();
        //BigMama bm = new BigMama(ph);
        //bm.programing();
        Programmer programmerWaterArmy  = (Programmer) Proxy.newProxyInstance(
                ph.getClass().getClassLoader(),ph.getClass().getInterfaces(),(proxy,method,args) -> {
              //如果调用programing方法
                    if (method.getName().equals("programing")){
                        method.invoke(ph,args);
                        System.out.println("WaterCode!");
                    }else {
                        return  method.invoke(ph,args);
                    }
                    return null;
                });

        programmerWaterArmy.programing();
    }
}
