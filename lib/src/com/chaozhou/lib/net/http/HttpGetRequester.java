package com.chaozhou.lib.net.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class HttpGetRequester extends HttpRequester{

	public HttpGetRequester(String uri) {
		super(uri);
	}

	public HttpUriRequest getRequest() {
		// TODO Auto-generated method stub
		return new HttpGet(uri);
	}
	
}