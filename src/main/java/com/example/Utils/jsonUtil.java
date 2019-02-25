package com.example.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;


public class jsonUtil {

    /**
     * 操作成功返回json
     * @return
     */
    public static JSONObject successResultJson(){
        JSONObject json = new JSONObject();
        json.put("satus","success");
        json.put("createtime",new Date());
        return json;
    }

    /***
     * 操作失败时返回的json
     * @return
     */
    public static JSONObject failedResultJson(){
        JSONObject json = new JSONObject();
        json.put("satus","failed");
        json.put("createtime",new Date());
        return json;
    }


    /**
     *接收字符串，返回json对象
     * @param str
     * @return
     */
    public static JSONObject String2JsonObject(String str){
        return new JSONObject(str);
    }

    /**
     * 因为springBoot默默认使用的json解析技术框架是jackson，所以返回
     * 的结果都是jsonobject对象无需转化
     * @param list
     * @return
     */
    public JSONArray List2JsonArray(List list){
        return new JSONArray(list);
    }
}
