package com.learn.redpacket;

import org.w3c.dom.ls.LSInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedPacketOperation {
    volatile RedPacket redPacket = null;
    User usr;
    Lock lock = new ReentrantLock();

    public RedPacketOperation(User usr) {
        this.usr = usr;
    }
    public RedPacketOperation(RedPacket redPct) {
        this.redPacket =redPct;
    }

    public synchronized void getRedPacket(User usr) {
        try {
            lock.lock();
            this.usr = usr;
            int size = redPacket.getDistrbtAmt().size();
            if (size>0 || redPacket.getDistrbtAmt()==null) {
                BigDecimal myAmt = redPacket.getDistrbtAmt().get(0);
                Map<User, BigDecimal> map = new HashMap<>();
                map.put(usr, myAmt);
                redPacket.setCountList(map);
                redPacket.getDistrbtAmt().remove(0);
                System.out.println(usr.getUsrName()+"抢到了：" + redPacket.getCountList().get(usr) + "元!");
            } else {
                System.out.println("红包已抢完！"+usr.getUsrName()+"空手而归...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public RedPacket sendRedPacket() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入红包个数：");
        int count = Integer.valueOf(input.readLine());
        System.out.println("输入红包金额：");
        String totalAmt = input.readLine();
        redPacket = distributeCount(new RedPacket(count, totalAmt));
        System.out.println(redPacket.getSendUser().getUsrName()+"发红包啦！");
        /*for (BigDecimal c : redPacket.getDistrbtAmt()) {
            System.out.println(c);
        }*/
        return redPacket;

    }

    public RedPacket distributeCount(RedPacket redPacket) {
        BigDecimal totalAmt = new BigDecimal(redPacket.getTotalAmt()); //单位：元
        BigDecimal count = new BigDecimal(redPacket.getCount());
        List<BigDecimal> redList = new ArrayList<BigDecimal>();
        BigDecimal minAmt = new BigDecimal("1");   //单位:分  方便计算
        BigDecimal maxAmt = totalAmt.multiply(BigDecimal.valueOf(100))
                .subtract(minAmt.multiply(count.subtract(BigDecimal.valueOf(1))));  //初始最大值为保证剩余元素都有最小值的前提下的余额
        for (int i = 0; i < Integer.valueOf(String.valueOf(count)) - 1; i++) {
            BigDecimal crtAmt = minAmt.add(BigDecimal.valueOf(new Random().nextInt(maxAmt.intValue())));
            redList.add(crtAmt.divide(BigDecimal.valueOf(100)).setScale(2));
            maxAmt = maxAmt.subtract(crtAmt).add(minAmt);    //之后每次最大值都为 上次最大值余额+保底最小值（因为不用保证上一个最小值了）
        }
        redList.add(maxAmt.divide(BigDecimal.valueOf(100)).setScale(2));
        redPacket.setDistrbtAmt(redList);
        redPacket.setSendUser(this.usr);
        return redPacket;
    }
}
