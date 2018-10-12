package com.winter.model;

import java.math.BigDecimal;
import java.util.Date;

public class AssetChange {
    private String assetchangeid;

    private String userid;

    private String coinid;

    private BigDecimal number;

    private String direction;

    private String customerid;

    private Date time;

    private String type;

    private String associateid;

    private String operatorid;

    private BigDecimal availableassetbeforechange;

    private BigDecimal frozenassetbeforechange;

    private BigDecimal totalassetbeforechange;

    private BigDecimal availableassetafterchange;

    private BigDecimal frozenassetafterchange;

    private BigDecimal totalassetafterchange;

    private String status;

    public String getAssetchangeid() {
        return assetchangeid;
    }

    public void setAssetchangeid(String assetchangeid) {
        this.assetchangeid = assetchangeid == null ? null : assetchangeid.trim();
    }

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

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAssociateid() {
        return associateid;
    }

    public void setAssociateid(String associateid) {
        this.associateid = associateid == null ? null : associateid.trim();
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid == null ? null : operatorid.trim();
    }

    public BigDecimal getAvailableassetbeforechange() {
        return availableassetbeforechange;
    }

    public void setAvailableassetbeforechange(BigDecimal availableassetbeforechange) {
        this.availableassetbeforechange = availableassetbeforechange;
    }

    public BigDecimal getFrozenassetbeforechange() {
        return frozenassetbeforechange;
    }

    public void setFrozenassetbeforechange(BigDecimal frozenassetbeforechange) {
        this.frozenassetbeforechange = frozenassetbeforechange;
    }

    public BigDecimal getTotalassetbeforechange() {
        return totalassetbeforechange;
    }

    public void setTotalassetbeforechange(BigDecimal totalassetbeforechange) {
        this.totalassetbeforechange = totalassetbeforechange;
    }

    public BigDecimal getAvailableassetafterchange() {
        return availableassetafterchange;
    }

    public void setAvailableassetafterchange(BigDecimal availableassetafterchange) {
        this.availableassetafterchange = availableassetafterchange;
    }

    public BigDecimal getFrozenassetafterchange() {
        return frozenassetafterchange;
    }

    public void setFrozenassetafterchange(BigDecimal frozenassetafterchange) {
        this.frozenassetafterchange = frozenassetafterchange;
    }

    public BigDecimal getTotalassetafterchange() {
        return totalassetafterchange;
    }

    public void setTotalassetafterchange(BigDecimal totalassetafterchange) {
        this.totalassetafterchange = totalassetafterchange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}