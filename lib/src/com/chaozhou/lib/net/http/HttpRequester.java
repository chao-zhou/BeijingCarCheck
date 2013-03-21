package com.chaozhou.lib.net.http;

import org.apache.http.client.methods.HttpUriRequest;

public abstract class HttpRequester{
	 
	protected String uri = null;
	
	public abstract HttpUriRequest getRequest();
	
	public HttpRequester(String uri){
		this.uri = uri;
	}
	
	
}
