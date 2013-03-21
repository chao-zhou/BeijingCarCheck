package com.chaozhou.lib.net.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class UrlEncoder {
	
	private String url = null;
	private String valueUrl = null;
	private String[] nameValueStrings = null;
	private List<NameValuePair> nameValuePairs = null;
		
	public UrlEncoder(String url){
		this.url = url;
	}
	
	public UrlEncodedFormEntity encodeUrlFormEntity(String url)
			throws UnsupportedEncodingException {
		
		getValueUrl();
		getNameValueString();
		getNameValuePair();
		return new UrlEncodedFormEntity(nameValuePairs);
	}
	
	private void getValueUrl(){
		int index = url.indexOf("?");
		if(index<0){
			valueUrl = url;
			return;
		}
		
		int head = index+1;
		int length = url.length()-head;
		valueUrl = url.substring(head,length);
	}
	
	private void getNameValueString(){	
		nameValueStrings = valueUrl.split("&");	
	}
	
	private void getNameValuePair(){
		nameValuePairs = new ArrayList<NameValuePair>();
		
		String[] params = null;
		for (int i = 0; i < nameValueStrings.length; i++) {
			params = nameValueStrings[i].split("=");
			if (params.length > 1) {
				nameValuePairs.add(new BasicNameValuePair(params[0], params[1]));
				continue;
			} 
			
			nameValuePairs.add(new BasicNameValuePair(params[0], ""));	
		}
	}
}
