package com.winter.mapper;

import com.winter.model.Entrust;

public interface EntrustMapper {
    int deleteByPrimaryKey(String entrustid);

    int insert(Entrust record);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(String entrustid);

    int updateByPrimaryKeySelective(Entrust record);

    int updateByPrimaryKey(Entrust record);
}