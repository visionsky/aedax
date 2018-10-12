package com.winter.model;

public class BankCard {

    private  String  bankCard_id;

    private  String  bankCardNumber;

    private  String bankCardName;

    private  String user_id;

    public BankCard() {
    }

    public BankCard(String bankCard_id, String bankCardNumber, String bankCardName, String user_id) {
        this.bankCard_id = bankCard_id;
        this.bankCardNumber = bankCardNumber;
        this.bankCardName = bankCardName;
        this.user_id = user_id;
    }

    public String getBankCard_id() {
        return bankCard_id;
    }

    public void setBankCard_id(String bankCard_id) {
        this.bankCard_id = bankCard_id;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
