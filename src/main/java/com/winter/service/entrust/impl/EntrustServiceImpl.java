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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "entrustService")
@Transactional
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
        record.setSurplusnumber(record.getEntrustnumber());
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
        String revokeId=StringUtils.UUID();
        record.setRevokeid(revokeId);

        int ret=revokeMapper.insert(record);
        if(ret!=1){return "insert failed";}
        ret=entrustMapper.revoke(record.getEntrustid(),record.getRevokenumber());
        if(ret==1)
            return revokeId;
        //else  return "update failed";
       throw new RuntimeException("update failed "+record.getEntrustid() +" "    +record.getRevokenumber());
    }

    @Override
    public List<Revoke> queryRevokes(Revoke record) {
        return revokeMapper.select(record);
    }

    @Override

    public String confirm(Transaction record,String entrustDirection) {
        String transactionId=StringUtils.UUID();
        record.setTransactionid(transactionId);
        String entrustId="";

        int ret=transactionMapper.insert(record);
        if(ret!=1){throw new RuntimeException("insert failed "+entrustId +" "    +record.getTransactionnumber());}

        if(!record.getBuyerentrustid().isEmpty()&&record.getBuyerentrustid().length()==32&&entrustDirection.equals("0")) {
            entrustId = record.getBuyerentrustid();

        }
        if(!record.getSellerentrustid().isEmpty()&&record.getSellerentrustid().length()==32&&entrustDirection.equals("1")) {
            entrustId = record.getSellerentrustid();
        }
        ret = entrustMapper.confirm(entrustId, record.getTransactionnumber(),entrustDirection);
        if(ret!=1){throw new RuntimeException("update failed "+entrustId +" "    +record.getTransactionnumber()+" "+entrustDirection);}
         else
            return transactionId;

    }
    public String confirm(Transaction record) {
        String transactionId=StringUtils.UUID();
        record.setTransactionid(transactionId);

        int ret=transactionMapper.insert(record);
        if(ret!=1){throw new RuntimeException("insert Failed " +" "    +record.getTransactionnumber());}
        ret = entrustMapper.confirm(record.getBuyerentrustid(), record.getTransactionnumber(),"0");
        if(ret!=1){throw new RuntimeException("update Buy Failed "+record.getBuyerentrustid() +" "    +record.getTransactionnumber());}
        ret = entrustMapper.confirm(record.getSellerentrustid(), record.getTransactionnumber(),"1");
        if(ret!=1){throw new RuntimeException("update Sell Failed "+record.getSellerentrustid() +" "    +record.getTransactionnumber());}
        else
            return transactionId;

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
