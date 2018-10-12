package com.winter.service.user;

import com.winter.model.User;
import com.winter.model.VerifyCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public interface VerifyService {

    int saveUUId(String uuid,String source,String ip);
    String queryUuid(String uuid,String source,String ip);
    int setPicCode(String uuid,String source,String ip,String type,String verifyPicCode);
    int updateStatus(String uuid);


    int deleteByPrimaryKey(String verifycodeId);
    int updateByPrimaryKeySelective(VerifyCode record);
}
