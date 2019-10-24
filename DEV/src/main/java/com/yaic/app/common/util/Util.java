package com.yaic.app.common.util;

import java.util.UUID;

import com.alibaba.fastjson.JSON;

public class Util {

	private Util(){}

	public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
		return replace;
    }

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static String getRandomString(int length) {
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; ++i) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

}
