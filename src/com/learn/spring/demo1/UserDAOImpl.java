package com.learn.spring.demo1;
/*
* 用户管理DAO层实现类
*
**/
public class UserDAOImpl implements UserDAO {
    @Override
    public void save (){
        System.out.println("UserDAOImpl执行了。。。");
    }
}
