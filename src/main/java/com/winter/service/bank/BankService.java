package com.winter.service.bank;

import com.winter.model.Bank;

import java.util.List;

public interface BankService {


    /**
     * 查询所有
     * @return
     */
    List<Bank> findAll();

    /**
     * 添加银行
     * @param bank
     */
    void  addBank(Bank bank);

    /**
     * 按照名称查询
     * @param name
     * @return
     */
    List<Bank> selectBankByName(String name);

    /**
     * 通过ID删除银行
     * @param bank_id
     */
    void  deleteById(Integer bank_id);

    /**
     * 修改银行
     * @param bank
     */
    void  updateBankById(Bank bank);

}
