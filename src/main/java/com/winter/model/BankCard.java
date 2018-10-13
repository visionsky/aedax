package com.winter.model;

public class Bankcard {
    private String bankcardId;

    private String bankcardnumber;

    private String bankcardname;

    private String userId;

    private String bankcardaddress;

    public String getBankcardId() {
        return bankcardId;
    }

    public void setBankcardId(String bankcardId) {
        this.bankcardId = bankcardId == null ? null : bankcardId.trim();
    }

    public String getBankcardnumber() {
        return bankcardnumber;
    }

    public void setBankcardnumber(String bankcardnumber) {
        this.bankcardnumber = bankcardnumber == null ? null : bankcardnumber.trim();
    }

    public String getBankcardname() {
        return bankcardname;
    }

    public void setBankcardname(String bankcardname) {
        this.bankcardname = bankcardname == null ? null : bankcardname.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBankcardaddress() {
        return bankcardaddress;
    }

    public void setBankcardaddress(String bankcardaddress) {
        this.bankcardaddress = bankcardaddress == null ? null : bankcardaddress.trim();
    }
}