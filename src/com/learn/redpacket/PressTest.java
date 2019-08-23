package com.learn.redpacket;


import java.math.BigDecimal;
import java.util.*;

//测试类，大量样本 看最佳手气红包分布
public class PressTest  {
    public static void main(String[] args) {
        RedPacket rdp = new RedPacket(10,"100");
        User usr = new User("wangchen");
        RedPacketOperation rdo = new RedPacketOperation(usr);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10000000;i++){
            List <BigDecimal> distrbtAmt  =rdo.distributeCount(rdp).getDistrbtAmt();
            BigDecimal max = distrbtAmt.get(0);
            int count = 0;
            for(int j = 0;j < distrbtAmt.size();j++){
                if(distrbtAmt.get(j).compareTo(max)==1){
                    max = distrbtAmt.get(j);
                    count=j;
                }
            }
            list.add(count);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : list){
            if(map.containsKey(i)){
                map.put(i,map.get(i).intValue()+1);
            }else {
                map.put(i,1);
            }
        }
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()){
            int key = iter.next();
            //System.out.println("第"+key+"个抢到大红包的有"+map.get(key)+"个");
            System.out.println(key+"|"+map.get(key));
        }
    }
}
