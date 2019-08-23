package com.learn.spring.Mybatis;

import com.learn.spring.Mybatis.mapper.QueryCustInfo;
import com.learn.spring.Mybatis.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            QueryCustInfo mapper = session.getMapper(QueryCustInfo.class);
            int count = mapper.selectCount();
            System.out.println("共有"+count+"条客户记录：");
            List<Customer> cst = mapper.selectAll();
            for (Customer customer : cst){
                System.out.println("ID:"+customer.getId()+",NAME:"+customer.getName()
                +"Source:"+customer.getSource()+"industry:"+customer.getIndustry()
                        +"Tel:"+customer.getTelPhone());
            }
            List <Customer> cstbase = mapper.selectBaseInfo();
            for(Customer cs :cstbase )
            {
                System.out.println(cs.getId()+cs.getName());
            }
        }finally {
            session.close();
        }
    }
}

