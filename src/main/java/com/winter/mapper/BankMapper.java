package com.winter.mapper;

import com.winter.model.Bank;

import java.util.List;

public interface BankMapper {


    List<Bank> findAll();

    void  addBank(Bank bank);

    List<Bank> selectBankByName(String name);

    void  deleteById(Integer bank_id);

    void  updateBankById(Bank bank);
}
