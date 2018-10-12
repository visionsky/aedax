package com.winter.mapper;
import java.util.List;
import com.winter.model.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(String transactionid);

    int insert(Transaction record);
    List<Transaction> select(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String transactionid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}