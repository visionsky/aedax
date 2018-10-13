package com.winter.mapper;

import com.winter.model.Entrust;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

public interface EntrustMapper {
    int deleteByPrimaryKey(String entrustid);

    int insert(Entrust record);
    List<Entrust> select(Entrust record);
    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(String entrustid);

    //@Update("<script> \n"+"update tb_entrust set cancelNumber=cancelNumber+#{cancelNumber},surplusNumber=surplusNumber-#{cancelNumber}  <if test=\"#{cancelNumber}>0\"> ,status='2' </if> where status='0' and entrustId=#{entrustId} and surplusNumber>=#{cancelNumber} "+ "</script> ")
    @Update("update tb_entrust set cancelNumber=cancelNumber+#{cancelNumber},surplusNumber=surplusNumber-#{cancelNumber},status = IF(surplusNumber=0,IF(transactionNumber>0,'1','2'),'0')   where status='0' and entrustId=#{entrustId} and surplusNumber>=#{cancelNumber} ")
    int revoke(@Param("entrustId")String entrustId,@Param("cancelNumber")BigDecimal cancelNumber);

    @Update("update tb_entrust set transactionNumber=transactionNumber+#{transactionNumber},surplusNumber=surplusNumber-#{transactionNumber},status = IF(surplusNumber=0,'1','0')   where status='0' and entrustId=#{entrustId} and entrustDirection=#{entrustDirection} and surplusNumber>=#{transactionNumber}")
    int confirm(@Param("entrustId")String entrustId,@Param("transactionNumber")BigDecimal transactionNumber,@Param("entrustDirection")String entrustDirection);

    int updateByPrimaryKeySelective(Entrust record);

    int updateByPrimaryKey(Entrust record);
}