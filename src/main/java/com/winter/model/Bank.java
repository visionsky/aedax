package com.winter.model;

public class Bank {

    private String bank_id;

    private  String name;

    public Bank() {
    }

    public Bank(String bank_id, String name) {
        this.bank_id = bank_id;
        this.name = name;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
