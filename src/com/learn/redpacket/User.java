package com.learn.redpacket;

public class User {
    private String usrId;
    private String usrName;

    public User(String usrName){
        this.usrName = usrName;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }


}
