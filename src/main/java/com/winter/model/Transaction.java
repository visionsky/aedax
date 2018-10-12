package com.winter.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private String transactionid;

    private String buyerentrustid;

    private String sellerentrustid;

    private BigDecimal transactionnumber;

    private Date transactiontime;

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public String getBuyerentrustid() {
        return buyerentrustid;
    }

    public void setBuyerentrustid(String buyerentrustid) {
        this.buyerentrustid = buyerentrustid == null ? null : buyerentrustid.trim();
    }

    public String getSellerentrustid() {
        return sellerentrustid;
    }

    public void setSellerentrustid(String sellerentrustid) {
        this.sellerentrustid = sellerentrustid == null ? null : sellerentrustid.trim();
    }

    public BigDecimal getTransactionnumber() {
        return transactionnumber;
    }

    public void setTransactionnumber(BigDecimal transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    public Date getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(Date transactiontime) {
        this.transactiontime = transactiontime;
    }
}