package com.learn.codeGather.gathe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class accessUrl {

	public static void main(String[] args) throws JSONException {
		String url = "http://api.map.baidu.com/telematics/v3/weather?location=%E6%88%90%E9%83%BD&output=json&ak=rnm8udmHdWaHFWZTO2tuTiG8";
		// String url =
		// "http://www.kuaidi100.com/query?type=yunda&postid=1201386764793";
		String json = getJson(url);
		JSONObject jsonObject=new JSONObject(json);
		System.out.println(jsonObject.get("status"));
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("a", "a");
		Long c=7463476L;
		jsonObject2.put("b", c.toString());
		System.out.println(jsonObject2.get("b").toString());
		System.out.println(jsonObject2.toString());
	}

	public static String getJson(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream(),"utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	

}
