package com.winter.mapper;

import com.winter.model.Bankcard;

public interface BankcardMapper {
    int deleteByPrimaryKey(String bankcardId);

    int insert(Bankcard record);

    int insertSelective(Bankcard record);

    Bankcard selectByPrimaryKey(String bankcardId);

    int updateByPrimaryKeySelective(Bankcard record);

    int updateByPrimaryKey(Bankcard record);
}