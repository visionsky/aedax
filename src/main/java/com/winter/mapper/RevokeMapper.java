package com.winter.mapper;

import com.winter.model.Revoke;

import java.util.List;

public interface RevokeMapper {
    int deleteByPrimaryKey(String revokeid);

    int insert(Revoke record);

    int insertSelective(Revoke record);
    List<Revoke> select(Revoke record);

    Revoke selectByPrimaryKey(String revokeid);

    int updateByPrimaryKeySelective(Revoke record);

    int updateByPrimaryKey(Revoke record);
}