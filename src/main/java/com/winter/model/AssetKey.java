package com.winter.model;

public class AssetKey {
    private String userid;

    private String coinid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCoinid() {
        return coinid;
    }

    public void setCoinid(String coinid) {
        this.coinid = coinid == null ? null : coinid.trim();
    }
}