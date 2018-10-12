package com.winter.mapper;

import com.winter.model.Coin;

public interface CoinMapper {
    int deleteByPrimaryKey(String coinId);

    int insert(Coin record);

    int insertSelective(Coin record);

    Coin selectByPrimaryKey(String coinId);

    int updateByPrimaryKeySelective(Coin record);

    int updateByPrimaryKeyWithBLOBs(Coin record);

    int updateByPrimaryKey(Coin record);
}