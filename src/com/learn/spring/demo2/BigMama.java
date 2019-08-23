package com.learn.spring.demo2;

public class BigMama implements Programmer {
    private Prophet ph;
    public BigMama(Prophet ph){
       this.ph= ph;
   }
   public void teach(){
       System.out.println("123456");
   }
    @Override
    public void programing() {
       ph.programing();
       teach();
    }
}
