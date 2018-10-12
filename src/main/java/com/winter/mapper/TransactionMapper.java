package com.winter.mapper;

import com.winter.model.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(String transactionid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String transactionid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}