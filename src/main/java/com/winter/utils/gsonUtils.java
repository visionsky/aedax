package com.winter.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class gsonUtils {

    public static String getStringValue(String resultStr,String value)
    {
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象       
        JsonObject jo = jp.parse(resultStr).getAsJsonObject();
        //获取message对应的值       
        JsonElement element=jo.get(value);
        if(element==null||element.isJsonNull())
            return "";
            else return element.getAsString();
    }
    public static JsonObject getJsonObjectValue(String resultStr,String value)
    {
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象       
        JsonObject jo = jp.parse(resultStr).getAsJsonObject();
        //获取message对应的值       
        return jo.get(value).getAsJsonObject();
    }

}
