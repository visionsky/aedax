package com.winter.service.bank.impl;

import com.winter.mapper.BankCardMapper;
import com.winter.model.BankCard;
import com.winter.service.bank.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankCardServiceImpl implements BankCardService {

    @Autowired
    private BankCardMapper bankCardMapper;

    @Override
    public List<BankCard> selectByUserId(String user_id) {
        return bankCardMapper.selectByUserId(user_id);
    }

    @Override
    public void addBankCard(BankCard bankCard) {

        bankCardMapper.addBankCard(bankCard);
    }

    @Override
    public void deleteByBankCardId(String bank_id) {

        bankCardMapper.deleteByBankCardId(bank_id);
    }

    @Override
    public void deleteByUserId(String user_id) {
        bankCardMapper.deleteByUserId(user_id);

    }
}
