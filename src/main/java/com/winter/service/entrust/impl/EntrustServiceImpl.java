package com.winter.service.entrust.impl;

import com.winter.mapper.EntrustMapper;
import com.winter.mapper.RevokeMapper;
import com.winter.mapper.TransactionMapper;
import com.winter.model.*;
import com.winter.service.entrust.EntrustService;
import com.winter.service.user.UserService;
import com.winter.utils.MD5Util;
import com.winter.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "entrustService")
public class EntrustServiceImpl implements EntrustService {


    @Autowired
    private EntrustMapper entrustMapper;//这里会报错，但是并不会影响

    @Autowired
    private RevokeMapper revokeMapper;//这里会报错，但是并不会影响

    @Autowired
    private TransactionMapper transactionMapper;//这里会报错，但是并不会影响

    @Override
    public String entrust(Entrust record) {
        String entrustId=StringUtils.UUID();
        record.setEntrustid(entrustId);
        BigDecimal amount=new BigDecimal("0.000");
        record.setCancelnumber(amount);
        record.setSurplusnumber(amount);
        record.setServicecharge(amount);
        record.setTransactionnumber(amount);
        int ret=entrustMapper.insert(record);
        if(ret==1)
            return entrustId;
        else return "";
    }

    @Override
    public List<Entrust> queryEntrusts(Entrust record) {
        return entrustMapper.select(record);
    }

    @Override
    public String revoke(Revoke record) {
        String entrustId=StringUtils.UUID();
        record.setRevokeid(entrustId);
        BigDecimal amount=new BigDecimal("0.000");

        int ret=revokeMapper.insert(record);
        if(ret==1)
            return entrustId;
        else return "";
    }

    @Override
    public List<Revoke> queryRevokes(Revoke record) {
        return revokeMapper.select(record);
    }

    @Override
    public String confirm(Transaction record) {
        String entrustId=StringUtils.UUID();
        record.setTransactionid(entrustId);
        BigDecimal amount=new BigDecimal("0.000");

        record.setTransactionnumber(amount);
        int ret=transactionMapper.insert(record);
        if(ret==1)
            return entrustId;
        else return "";
    }

    @Override
    public List<Transaction> queryTransactions(Transaction record) {
        return transactionMapper.select(record);
    }



    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    /*
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
       return userMapper.selectAllUser();
    }*/
}
