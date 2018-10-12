package com.winter.mapper;

import com.winter.model.BankCard;

import java.util.List;

public interface BankCardMapper {

    List<BankCard> selectByUserId(String user_id);

    void addBankCard(BankCard bankCard);

    void  deleteByBankCardId(String bank_id);

    void  deleteByUserId(String user_id);

}
