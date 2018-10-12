package com.winter.model;

import java.util.Date;

public class User {
    private String userId;

    private String nickname;

    private String username;

    private String phone;

    private String email;

    private String idcardnum;

    private String password;

    private String apppassword;

    private String paypassword;

    private Date registerdate;

    private String invitecode;

    private String inviteuserid;

    private String registersource;

    private String defaultbankcardId;

    private Date lastchangedate;

    private String tokenid;

    private Date tokenexpiredate;
    private String idCardFront;
    private String idCardOpposite;
    private String level;

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public String getIdCardOpposite() {
        return idCardOpposite;
    }

    public void setIdCardOpposite(String idCardOpposite) {
        this.idCardOpposite = idCardOpposite;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String status;
    public User(){

    }
    public User(String userId,String nickname,String phone,String email,String source,String password,String inviteCode,String inviteuserid){
        this.userId=userId;
        this.nickname=nickname;
        this.phone= phone;
        registersource=source;
        this.email=email;
        this.password=password;
        this.invitecode=inviteCode;
        this.inviteuserid=inviteuserid;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum == null ? null : idcardnum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getApppassword() {
        return apppassword;
    }

    public void setApppassword(String apppassword) {
        this.apppassword = apppassword == null ? null : apppassword.trim();
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword == null ? null : paypassword.trim();
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode == null ? null : invitecode.trim();
    }

    public String getInviteuserid() {
        return inviteuserid;
    }

    public void setInviteuserid(String inviteuserid) {
        this.inviteuserid = inviteuserid == null ? null : inviteuserid.trim();
    }

    public String getRegistersource() {
        return registersource;
    }

    public void setRegistersource(String registersource) {
        this.registersource = registersource == null ? null : registersource.trim();
    }

    public String getDefaultbankcardId() {
        return defaultbankcardId;
    }

    public void setDefaultbankcardId(String defaultbankcardId) {
        this.defaultbankcardId = defaultbankcardId == null ? null : defaultbankcardId.trim();
    }

    public Date getLastchangedate() {
        return lastchangedate;
    }

    public void setLastchangedate(Date lastchangedate) {
        this.lastchangedate = lastchangedate;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid == null ? null : tokenid.trim();
    }

    public Date getTokenexpiredate() {
        return tokenexpiredate;
    }

    public void setTokenexpiredate(Date tokenexpiredate) {
        this.tokenexpiredate = tokenexpiredate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}