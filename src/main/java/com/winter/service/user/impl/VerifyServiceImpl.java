package com.winter.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.winter.mapper.VerifyCodeMapper;
import com.winter.model.VerifyCode;
import com.winter.service.user.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "verifyService")
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private VerifyCodeMapper verifyCodeMapper;//这里会报错，但是并不会影响

    @Override
    public int saveUUId(String uuid,String source,String ip) {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.setVerifycodeId(uuid);
        verifyCode.setIp(ip);
        verifyCode.setSource(source);
        verifyCode.setStatus("1");

        return verifyCodeMapper.insertSelective(verifyCode);
    }

    @Override
    public String queryUuid(String uuid,String source,String ip) {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.setVerifycodeId(uuid);
        verifyCode.setIp(ip);
        verifyCode.setSource(source);
        VerifyCode verify=verifyCodeMapper.selectByAll(verifyCode);

        return verify.getStatus();
    }

    @Override
    public int updateStatus(String uuid) {
        return verifyCodeMapper.updateStatus(uuid);
    }



    @Override
    public int setPicCode(String uuid, String source, String ip, String type, String verifyPicCode) {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.setVerifycodeId(uuid);
        verifyCode.setIp(ip);
        verifyCode.setSource(source);

        verifyCode.setType(type);
        verifyCode.setVerifypiccode(verifyPicCode);
        verifyCode.setStatus("2");
        return verifyCodeMapper.updateByPrimaryKeySelective(verifyCode);


    }

    @Override
    public int deleteByPrimaryKey(String verifycodeId) {
       // return 0;
        return verifyCodeMapper.deleteByPrimaryKey(verifycodeId);
    }


    @Override
    public int updateByPrimaryKeySelective(VerifyCode record){
        //return 0;
      return verifyCodeMapper.updateByPrimaryKeySelective(record);
    }
}
