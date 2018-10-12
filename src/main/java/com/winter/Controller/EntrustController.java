package com.winter.Controller;


import com.winter.service.user.UserService;
import com.winter.service.user.VerifyService;
import com.winter.utils.IPUtil;
import com.winter.utils.SCaptcha;
import com.winter.utils.StringUtils;
import com.winter.utils.picUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

@RequestMapping("/v1/api")
public class EntrustController {

    @Autowired
    private UserService userService;
    @Autowired
    private VerifyService verifyService;


    @PostMapping("/getUuid/{source}")
    @RequestMapping("/getUuid/{source}")
    public String getUuid(@PathVariable("source") String source,HttpServletRequest request) {

        String uuid=StringUtils.UUID();
        String ip = IPUtil.getIP(request);
        int ret=verifyService.saveUUId(uuid,source,ip);
       if(ret==1)return uuid;
       else
        return "服务器连接错误";
    }

    @GetMapping("/queryUuid/{source}/{uuid}")
    //@RequestMapping("/queryUuid/{source}/{uuid}")
    public String queryUuid(@PathVariable("source") String source,@PathVariable("uuid") String uuid,HttpServletRequest request) {

        String ip = IPUtil.getIP(request);
        return verifyService.queryUuid(uuid,source,ip);

    }
   @PostMapping("/registerUser/{source}/{uuid}/{nickname}/{phone}/{verifyPicCode}/{verifySmsCode}/{password}/{inviteCode}")
   //@RequestMapping("/registerUser/{source}/{uuid}/{nickname}/{phone}/{verifyPicCode}/{verifySmsCode}/{password}/{inviteCode}")
    public String registerUser(@PathVariable("source") String source,@PathVariable("uuid") String uuid,@PathVariable("nickname") String nickname,@PathVariable("phone") String phone,@PathVariable("verifyPicCode") String verifyPicCode,@PathVariable("verifySmsCode") String verifySmsCode,@PathVariable("password") String password,@PathVariable("inviteCode") String inviteCode,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);
      //  User register = new User();

        String ret= userService.registerUser( uuid, ip,nickname, phone, source, verifyPicCode, verifySmsCode, password, inviteCode);
        return ret;
        //  return userService.getUser();
    }

    @GetMapping("/checkRegisterUser/{phone}/{email}/{idCardNum}")
    //@RequestMapping("/checkRegisterUser/{phone}/{email}/{idCardNum}")
    public String checkRegisterUser(@PathVariable("phone") String phone,@PathVariable("email") String email,@PathVariable("idCardNum") String idCardNum) {
      //   email = "1@163.com";
       //  idCardNum = "420505207205042017";

        //phone= "";
        // String ret= userService.userTest(para);
        int ret=userService.checkRegisterUser( phone, email,idCardNum);
        return ret+"";
        //  return userService.getUser();
    }
    @PutMapping("/login/{source}/{nickname}/{phone}/{password}")
    //@RequestMapping("/login/{source}/{nickname}/{phone}/{password}")
    public String login(@PathVariable("source") String source,@PathVariable("nickname") String nickname,@PathVariable("phone") String phone,@PathVariable("password") String password,HttpServletRequest request) {
        String email = "";//"1@163.com";
        nickname="";
        //phone= "";
       // String ret= userService.userTest(para);
        String ret=userService.login( phone,nickname, email,password);
        return ret;
        //  return userService.getUser();
    }
    //@DeleteMapping
   @PutMapping("/login/{source}/{userid}/{tokenid}")
   //@RequestMapping("/logout/{source}/{userid}/{tokenid}")
    public int logout(@PathVariable("source") String source,@PathVariable("userid") String userid,@PathVariable("tokenid") String tokenid) {
        int ret=userService.logout(userid,tokenid);
        return  ret;
        //  return userService.getUser();
    }

    @PutMapping("/findPassword/{source}/{userid}/{tokenid}/{phone}/{verifyPicCode}/{verifySmsCode}/{password}")
    //@RequestMapping("/findPassword/{source}/{userid}/{tokenid}/{phone}/{verifyPicCode}/{verifySmsCode}/{password}")
    public String findPassword(@PathVariable("source") String source,@PathVariable("userid") String userid,@PathVariable("tokenid") String tokenid,@PathVariable("phone") String phone,@PathVariable("verifyPicCode") String verifyPicCode,@PathVariable("verifySmsCode") String verifySmsCode,@PathVariable("password") String password,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);
        String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
        return ret;
        //  return userService.getUser();
    }

//http://localhost:1111/v1/api/test/3?userid=bii&tokenid=rrr
   // @GetMapping("test/{source}") //@RequestParam 对应mutipartBody  application/x-www-form-urlencoded idList=aaa&tokenid=%E6%89%93%E5%8F%91%E6%89%8B%E5%8A%A8%E9%98%80&useid=%E6%B8%A9%E7%83%AD%E5%A8%81%E5%A8%81
    //
    @PostMapping("test/{source}")//@RequestBody applicaton/json

    public String test(@PathVariable("source") String source,@RequestBody(required =false )  String idList,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);

        // String userid= JsonUtils.parseJson(idList,"");
      //  String tokenid=idList.get(1);
        //String tst=gsonUtils.getStringValue(idList,"tokenid");


        // String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
        return ip;
        //  return userService.getUser();
    }



   /*
   public Map test(@RequestParam(required = false) String userid,@RequestParam(required = false) String tokenid,@PathVariable("source") String source,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("source", source);
        map.put("ip", ip);
        map.put("userid", userid);
        map.put("tokenid", tokenid);
       // String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
        return map;
        //  return userService.getUser();
    }
   public Map test(@PathVariable("source") String source,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("source", source);
        map.put("ip", ip);
       // String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
        return map;
        //  return userService.getUser();
    }

    public List<User> listUser(){
        return userService.findAllUser(1,10);
    }*/
   /*
   @ResponseBody
   @RequestMapping(value = "/md5")
   public String get() {

       //  return "My gods !";
       return MD5Util.getMD5String("eerererer");
   }*/
   /*
   @RequestMapping(value = "/verifyPicCode/{source}")
   @ResponseBody
   public void verifyPicCode(@PathVariable("source") String source, HttpServletRequest request, HttpServletResponse response) throws IOException {

        verifyPic( source,  "", request,  response) ;

   }*/
    @RequestMapping(value = "/verifyPicCode/{source}/{uuid}")
   // @ResponseBody
    public String verifyPicCode(@PathVariable("source") String source, @PathVariable("uuid") String uuid,HttpServletRequest request, HttpServletResponse response) throws IOException {


       // Map<String,Object> map=new HashMap<String,Object>();
       // map.put("source", source);
      //  map.put("code", verifyPic( source,  uuid, request,  response));
        // String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
      //  return map;
         return verifyPic( source,  uuid, request,  response) ;

    }
    @RequestMapping(value = "/verifySmsCode/{source}/{uuid}/{phone}")
   // @ResponseBody
    public String verifySmsCode(@PathVariable("source") String source, @PathVariable("uuid") String uuid, @PathVariable("phone") String phone,HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "success";

    }

    public String verifyPic(String source, String uuid,HttpServletRequest request, HttpServletResponse response) throws IOException {


                String ip = IPUtil.getIP(request);

                //  X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
               //用户真实IP为： 192.168.1.110

                 String type ="1";


                 //实例生成验证码对象
                 SCaptcha instance = new SCaptcha();
                 String verifyPicCode=instance.getCode();
                 //String verifySmsCode=instance.getCode();
                 //将验证码存入session
                 //session.setAttribute("verification", instance.getCode());
                 if(verifyService.setPicCode(uuid,source,ip,type,verifyPicCode)==1){
                     picUtil.writePic(instance,response);return "successed";
                 }
                 else return "failed";


     }
/*
    public Map test(@PathVariable("source") String source,@RequestBody  Map<String, Object> models,HttpServletRequest request) {
        String ip = IPUtil.getIP(request);

        String userid= JsonXmlUtils.map2obj((Map<String, Object>)models.get("userid"),String.class);
        String tokenid=JsonXmlUtils.map2obj((Map<String, Object>)models.get("tokenid"),String.class);


        Map<String,Object> map=new HashMap<String,Object>();
        if(true) return map;
        map.put("source", source);
        map.put("ip", ip);
        map.put("userid", userid);
        map.put("tokenid", tokenid);
        // String ret=userService.changePassword(  userid, tokenid, ip, source, phone, verifyPicCode, verifySmsCode, password);
        return map;
        //  return userService.getUser();
    }
*/

}
