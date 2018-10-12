package com.winter.mapper;

import com.winter.model.AssetChange;

public interface AssetChangeMapper {
    int insert(AssetChange record);

    int insertSelective(AssetChange record);
}