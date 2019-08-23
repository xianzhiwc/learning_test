package com.learn.spring.Mybatis.mapper;

import com.learn.spring.Mybatis.pojo.Customer;

import java.util.List;

public abstract  interface QueryCustInfo {
    public abstract List<Customer> selectAll();
    public  abstract  int selectCount();
    public abstract List<Customer> selectBaseInfo();
}
