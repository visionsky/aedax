package com.winter.model;

/**
 * Created by shenyiya on 2018/9/7
 * Email: shenyiya@huobi.com com.winter.model.VisionWallet
 */
public class VisionWallet {
    private int index;
    private int coinType;
    private String privateKey;
    private String publicKey;
    private String address;
    private String name;

    public VisionWallet(int index, int coinType, String privateKey, String publicKey, String address, String name) {
        this.index = index;
        this.coinType = coinType;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.address = address;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCoinType() {
        return coinType;
    }

    public void setCoinType(int coinType) {
        this.coinType = coinType;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
