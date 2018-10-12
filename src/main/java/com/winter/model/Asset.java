package com.winter.model;

import java.math.BigDecimal;
import java.util.Date;

public class Asset extends AssetKey {
    private BigDecimal availableasset;

    private BigDecimal frozenasset;

    private BigDecimal totalasset;

    private Date updatetime;

    private String walletaddress;

    private String memowords;

    private String publickey;

    private String privatekey;

    private String status;

    public BigDecimal getAvailableasset() {
        return availableasset;
    }

    public void setAvailableasset(BigDecimal availableasset) {
        this.availableasset = availableasset;
    }

    public BigDecimal getFrozenasset() {
        return frozenasset;
    }

    public void setFrozenasset(BigDecimal frozenasset) {
        this.frozenasset = frozenasset;
    }

    public BigDecimal getTotalasset() {
        return totalasset;
    }

    public void setTotalasset(BigDecimal totalasset) {
        this.totalasset = totalasset;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getWalletaddress() {
        return walletaddress;
    }

    public void setWalletaddress(String walletaddress) {
        this.walletaddress = walletaddress == null ? null : walletaddress.trim();
    }

    public String getMemowords() {
        return memowords;
    }

    public void setMemowords(String memowords) {
        this.memowords = memowords == null ? null : memowords.trim();
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey == null ? null : privatekey.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}