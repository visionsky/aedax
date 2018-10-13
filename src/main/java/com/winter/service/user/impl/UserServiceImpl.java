package com.winter.service.user.impl;

import com.winter.mapper.VerifyCodeMapper;
import com.winter.model.User;
import com.winter.model.VerifyCode;
import com.winter.service.user.UserService;
import com.winter.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winter.mapper.UserMapper;
import  com.winter.utils.MD5Util;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响
    @Autowired
    private VerifyCodeMapper verifyCodeMapper;//这里会报错，但是并不会影响



    @Override
    public String login(String phone, String nickname, String email, String password) {
        String userId= userMapper.getUserId(phone, nickname, email);
       // if(true)return userId;
      //  Map<String,Object> map = new HashMap<>();
       // map.put("userInfo",userInfo);
       // map.put("page",page);
        password=MD5Util.getMD5String(userId+password);
        String tokenid=StringUtils.UUID();
        int ret=userMapper.login(userId, password,tokenid);
        if(ret==1)
        return tokenid;
        else return "";
    }

    @Override

    public int logout(String userid, String tokenid) {
        return userMapper.logout(userid, tokenid);
    }

    @Override

    public String changePassword(String userid,String tokenid,String ip,String source,String phone,String verifyPicCode,String verifySmsCode,String password) {
        String uuid=queryVerifyCode( "",userid, source, phone, ip, verifyPicCode, verifySmsCode);
            if(uuid==null||uuid.isEmpty())
                return "验证码错误";
        password=MD5Util.getMD5String(userid+password);
        int line=userMapper.changePassword( userid, tokenid, phone, password);
        if(line==1) {
            line=verifyCodeMapper.updateStatus(uuid);
            if(line==1)return userid;
        }
        return "注册失败";
    }


    @Override

    public String registerUser(String uuid,String ip,String nickname,String phone,String source,String verifyPicCode,String verifySmsCode,String password,String inviteCode) {
        String email="";
        String inviteuserid="";
        uuid=queryVerifyCode( uuid,"", source, phone, ip, verifyPicCode, verifySmsCode);
        if(uuid==null||uuid.isEmpty())
            return "验证码错误";//checkRegisterUser( phone, email,idCardNum)
        if(checkRegisterUser( phone,"", "")>0)
            return "已注册";
        String userId= StringUtils.UUID();
        long id=userMapper.countUser()+1;
        password=MD5Util.getMD5String(userId+password);
        if(!inviteCode.isEmpty()&&inviteCode.length()>0)inviteuserid=userMapper.getInviterUserId(inviteCode);
        inviteCode= StringUtils.toSerialCode(id);
        User register = new User( userId, nickname, phone, email, source, password, inviteCode, inviteuserid);
        int line=userMapper.insertSelective(register);
        if(line==1) {
            line=verifyCodeMapper.updateStatus(uuid);
            if(line==1)return userId;
        }
        return "注册失败";
    }

    @Override
    public int checkRegisterUser(String phone, String email,String idCardNum) {
        User register = new User();
        register.setPhone(phone);
        register.setEmail(email);
        register.setIdcardnum(idCardNum);
        int ret=userMapper.checkRegisterUser(register);

        return ret;
    }

    @Override
    public String userTest( String inviteCode) {
        return userMapper.getInviterUserId(inviteCode);
       // return userMapper.countUser().toString();
        //return userMapper.getUser().toString();
        //  return userMapper.getUser().getUserName();
    }

    public String  queryVerifyCode(String uuid,String userid,String source,String phone,String ip,String verifyPicCode,String verifySmsCode) {
        VerifyCode verifyCode=new VerifyCode();
        verifyCode.setVerifycodeId(uuid);
        verifyCode.setUserId(userid);
        verifyCode.setIp(ip);
        verifyCode.setSource(source);
        verifyCode.setPhone(phone);
        verifyCode.setVerifypiccode(verifyPicCode);
        verifyCode.setVerifysmscode(verifySmsCode);
        verifyCode.setStatus("2");
        VerifyCode verify=verifyCodeMapper.selectByAll(verifyCode);
        if(verify!=null)
            return verify.getVerifycodeId();
        else return "";
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
