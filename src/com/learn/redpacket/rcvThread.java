package com.learn.redpacket;

public class rcvThread implements Runnable {
    private User usr;
    private RedPacketOperation rdpo;
    public rcvThread(User usr,RedPacketOperation rdpo){
        this.usr= usr;
        this.rdpo = rdpo;
    }
    @Override
    public void run() {
        rdpo.getRedPacket(usr);
    }
}
