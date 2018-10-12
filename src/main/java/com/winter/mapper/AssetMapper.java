package com.winter.mapper;

import com.winter.model.Asset;
import com.winter.model.AssetKey;

public interface AssetMapper {
    int deleteByPrimaryKey(AssetKey key);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(AssetKey key);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}