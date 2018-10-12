package com.winter.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class picUtil {
    public static void writePic(SCaptcha instance,HttpServletResponse response) throws IOException {



        //实例生成验证码对象



        //   if(true) return  ip+ "|"+type+ "|"+source+ "|"+verifyPicCode+ "|"+phone;
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //向页面输出验证码图片
        instance.write(response.getOutputStream());
        //   return  ip+ "|"+type+ "|"+source+ "|"+verifyPicCode+ "|"+uuid;



    }
}
