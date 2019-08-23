package com.learn.spring.Mybatis.pojo;

public class Customer {
    int id;
    String name;
    String source;
    String industry;
    String telPhone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getIndustry() {
        return industry;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
}
