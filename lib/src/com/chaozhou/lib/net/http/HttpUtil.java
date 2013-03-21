package com.chaozhou.lib.net.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.entity.UrlEncodedFormEntity;

public class HttpUtil {
	
	public static UrlEncodedFormEntity encodeUrlFormEntity(String url)
			throws UnsupportedEncodingException {
		return new UrlEncoder(url).encodeUrlFormEntity(url);
	}
}
