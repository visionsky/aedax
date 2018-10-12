package com.winter.service.user;

import com.winter.model.User;
import com.winter.model.VerifyCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public interface VerifyService {

    @Transactional
    int saveUUId(String uuid,String source,String ip);
    String queryUuid(String uuid,String source,String ip);
    @Transactional
    int setPicCode(String uuid,String source,String ip,String type,String verifyPicCode);
    @Transactional
    int updateStatus(String uuid);


    int deleteByPrimaryKey(String verifycodeId);
    int updateByPrimaryKeySelective(VerifyCode record);
}
