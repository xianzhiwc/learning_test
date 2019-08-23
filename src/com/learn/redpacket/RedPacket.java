package com.learn.redpacket;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedPacket {
    private int count = 1; //总个数
    private String totalAmt = null;//总金额
    private List <BigDecimal> distrbtAmt ;  //红包金额数组
    private Map<User,BigDecimal> countList;  //红包列表
    private User sendUser;  //发红包用户

    public RedPacket(int count, String totalAmt){
        this.count = count;
        this.totalAmt = totalAmt;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }


    public List <BigDecimal> getDistrbtAmt() {
        return distrbtAmt;
    }

    public void setDistrbtAmt(List <BigDecimal> distrbtAmt) {
        this.distrbtAmt = distrbtAmt;
    }

    public Map<User,BigDecimal> getCountList() {
        return countList;
    }

    public void setCountList(Map<User,BigDecimal> countList) {
        this.countList = countList;
    }

}
