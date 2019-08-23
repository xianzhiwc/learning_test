package com.learn.redpacket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        User usr = new User("wangchen");
        RedPacketOperation send = new RedPacketOperation(usr);
        RedPacket rdp = send.sendRedPacket();
        List<User> usrList = new ArrayList<>();
        for (int i = 0;i<10;i++){
            usrList.add(new User("用户"+i));
        }
        RedPacketOperation rcv = new RedPacketOperation(rdp);
        for(User u : usrList){
            new Thread(new RcvThread(u,rcv)).start();
        }
       // re.getRedPacket(rdp);
    }
}
