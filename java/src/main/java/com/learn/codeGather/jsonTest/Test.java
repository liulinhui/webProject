package com.learn.codeGather.jsonTest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by linkage on 2016-11-17.
 */
public class Test {
    public static void main(String[] args) {
        String JsonContext = new Utils().ReadFile("java/src/main/resources/config.json");
        JSONObject jsonObject=new JSONObject(JsonContext);
        int size = jsonObject.length();
        System.out.println("Size: " + size);
        System.out.println(jsonObject.toString());
    }
}
