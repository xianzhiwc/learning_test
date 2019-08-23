package com.learn.redpacket;

import java.io.IOException;

public class sendThread implements Runnable {
    private User sendusr;
    public sendThread(User usr){
        this.sendusr = usr;
    }
    @Override
    public void run() {
        RedPacketOperation re = new RedPacketOperation(sendusr);
        try {
            re.sendRedPacket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
