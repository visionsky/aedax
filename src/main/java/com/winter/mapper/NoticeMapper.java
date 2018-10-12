package com.winter.mapper;

import com.winter.model.Notice;

public interface NoticeMapper {
    int insert(Notice record);

    int insertSelective(Notice record);
}