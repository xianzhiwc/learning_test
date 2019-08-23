package com.learn.redpacket;

public class RcvThread implements Runnable {
    private User usr;
    private RedPacketOperation rdpo;
    public RcvThread(User usr, RedPacketOperation rdpo){
        this.usr= usr;
        this.rdpo = rdpo;
    }
    @Override
    public void run() {
        rdpo.getRedPacket(usr);
    }
}
