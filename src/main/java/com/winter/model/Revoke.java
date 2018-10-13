package com.winter.model;

import java.math.BigDecimal;
import java.util.Date;

public class Revoke {
    private String revokeid;

    private Date revoketime;

    private String entrustid;

    private BigDecimal revokenumber;


    public Revoke(){

    }
    public Revoke(String revokeid,String revokenumber){
        this.revokeid=revokeid;
        this.revokenumber=new BigDecimal(revokenumber);

    }

    public String getRevokeid() {
        return revokeid;
    }

    public void setRevokeid(String revokeid) {
        this.revokeid = revokeid == null ? null : revokeid.trim();
    }

    public Date getRevoketime() {
        return revoketime;
    }

    public void setRevoketime(Date revoketime) {
        this.revoketime = revoketime;
    }

    public String getEntrustid() {
        return entrustid;
    }

    public void setEntrustid(String entrustid) {
        this.entrustid = entrustid == null ? null : entrustid.trim();
    }

    public BigDecimal getRevokenumber() {
        return revokenumber;
    }

    public void setRevokenumber(BigDecimal revokenumber) {
        this.revokenumber = revokenumber;
    }
}