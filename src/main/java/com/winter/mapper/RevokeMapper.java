package com.winter.mapper;

import com.winter.model.Revoke;

public interface RevokeMapper {
    int deleteByPrimaryKey(String revokeid);

    int insert(Revoke record);

    int insertSelective(Revoke record);

    Revoke selectByPrimaryKey(String revokeid);

    int updateByPrimaryKeySelective(Revoke record);

    int updateByPrimaryKey(Revoke record);
}