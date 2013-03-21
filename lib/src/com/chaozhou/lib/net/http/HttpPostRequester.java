package com.chaozhou.lib.net.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

class HttpPostRequester extends HttpRequester {

	private UrlEncodedFormEntity entity = null;
	
	public HttpPostRequester(String uri,String formValues) throws UnsupportedEncodingException {
		super(uri);
		entity = HttpUtil.encodeUrlFormEntity(formValues);
	}
	
	public HttpPostRequester(String uri,UrlEncodedFormEntity entity){
		super(uri);
		this.entity = entity;
	}

	public HttpUriRequest getRequest() {
		HttpPost request = new HttpPost(uri);
		request.setEntity(entity);
		return request;
	}

	
}
