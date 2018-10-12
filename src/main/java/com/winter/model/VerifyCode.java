package com.winter.model;

import java.util.Date;

public class VerifyCode {
    private String verifycodeId;

    private String verifypiccode;

    private String verifysmscode;

    private String userId;

    private String source;

    private String ip;

    private String type;

    private String phone;

    private Date expireddate;

    private String status;

    public String getVerifycodeId() {
        return verifycodeId;
    }

    public void setVerifycodeId(String verifycodeId) {
        this.verifycodeId = verifycodeId == null ? null : verifycodeId.trim();
    }

    public String getVerifypiccode() {
        return verifypiccode;
    }

    public void setVerifypiccode(String verifypiccode) {
        this.verifypiccode = verifypiccode == null ? null : verifypiccode.trim();
    }

    public String getVerifysmscode() {
        return verifysmscode;
    }

    public void setVerifysmscode(String verifysmscode) {
        this.verifysmscode = verifysmscode == null ? null : verifysmscode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getExpireddate() {
        return expireddate;
    }

    public void setExpireddate(Date expireddate) {
        this.expireddate = expireddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}