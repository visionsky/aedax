package com.winter.service.user;

import com.winter.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public interface UserService {


    //long getUserCount();
    String userTest( String inviteCode);
    @Transactional
    String registerUser(String uuid,String ip,String nickname,String phone,String source,String verifyPicCode,String verifySmsCode,String password,String inviteCode);
    int checkRegisterUser(String phone,String email,String idCardNum);
    @Transactional
    String login( String phone,String nickname,String email,String password);
    @Transactional
    int logout( String userid,String tokenid);
    @Transactional
    String changePassword( String userid,String tokenid,String ip,String source,String phone,String verifyPicCode,String verifySmsCode,String password);

 //   List<User> findAllUser(int pageNum, int pageSize);
}
