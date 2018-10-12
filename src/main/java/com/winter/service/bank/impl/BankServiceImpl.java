package com.winter.service.bank.impl;

import com.winter.mapper.BankMapper;
import com.winter.model.Bank;
import com.winter.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl  implements BankService {

    @Autowired
    private BankMapper bankMapper;


    @Override
    public List<Bank> findAll() {
        return bankMapper.findAll();
    }

    @Override
    public void addBank(Bank bank) {

        String bank_id = UUID.randomUUID().toString();

        bank.setBank_id(bank_id);

        bankMapper.addBank(bank);
    }

    @Override
    public List<Bank> selectBankByName(String name) {
        return bankMapper.selectBankByName(name);
    }

    @Override
    public void deleteById(Integer bank_id) {
            bankMapper.deleteById(bank_id);
    }

    @Override
    public void updateBankById(Bank bank) {

        bankMapper.updateBankById(bank);
    }
}
