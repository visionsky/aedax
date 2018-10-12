package com.winter.mapper;

import com.winter.model.VerifyCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerifyCodeMapper {


    int insertSelective(VerifyCode record);
    VerifyCode selectByAll(VerifyCode record);
    int updateByPrimaryKeySelective(VerifyCode record);
    int updateStatus(String uuid);




    VerifyCode selectByPrimaryKey(String verifycodeId);





    int deleteByPrimaryKey(String verifycodeId);

}