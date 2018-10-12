package com.winter.model;

import java.math.BigDecimal;
import java.util.Date;

public class Entrust {
    private String entrustid;

    private String userid;

    private String outcoinid;

    private String incoinid;

    private String entrustdirection;

    private String type;

    private BigDecimal entrustnumber;

    private BigDecimal coinprice;

    private BigDecimal servicecharge;

    private BigDecimal transactionnumber;

    private BigDecimal cancelnumber;

    private BigDecimal surplusnumber;

    private Date entrusttime;

    private String status;

    public String getEntrustid() {
        return entrustid;
    }

    public void setEntrustid(String entrustid) {
        this.entrustid = entrustid == null ? null : entrustid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOutcoinid() {
        return outcoinid;
    }

    public void setOutcoinid(String outcoinid) {
        this.outcoinid = outcoinid == null ? null : outcoinid.trim();
    }

    public String getIncoinid() {
        return incoinid;
    }

    public void setIncoinid(String incoinid) {
        this.incoinid = incoinid == null ? null : incoinid.trim();
    }

    public String getEntrustdirection() {
        return entrustdirection;
    }

    public void setEntrustdirection(String entrustdirection) {
        this.entrustdirection = entrustdirection == null ? null : entrustdirection.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getEntrustnumber() {
        return entrustnumber;
    }

    public void setEntrustnumber(BigDecimal entrustnumber) {
        this.entrustnumber = entrustnumber;
    }

    public BigDecimal getCoinprice() {
        return coinprice;
    }

    public void setCoinprice(BigDecimal coinprice) {
        this.coinprice = coinprice;
    }

    public BigDecimal getServicecharge() {
        return servicecharge;
    }

    public void setServicecharge(BigDecimal servicecharge) {
        this.servicecharge = servicecharge;
    }

    public BigDecimal getTransactionnumber() {
        return transactionnumber;
    }

    public void setTransactionnumber(BigDecimal transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    public BigDecimal getCancelnumber() {
        return cancelnumber;
    }

    public void setCancelnumber(BigDecimal cancelnumber) {
        this.cancelnumber = cancelnumber;
    }

    public BigDecimal getSurplusnumber() {
        return surplusnumber;
    }

    public void setSurplusnumber(BigDecimal surplusnumber) {
        this.surplusnumber = surplusnumber;
    }

    public Date getEntrusttime() {
        return entrusttime;
    }

    public void setEntrusttime(Date entrusttime) {
        this.entrusttime = entrusttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}