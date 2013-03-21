package com.chaozhou.lib.net.http;

import java.io.IOException;

import org.apache.http.HttpResponse;

public abstract class HttpResponser<T>{
	
	protected HttpResponse response = null;

	public abstract T getResponse()throws IllegalStateException, IOException;
	
	public HttpResponser(HttpResponse response){
		this.response = response;
	}
	

}
