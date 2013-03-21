package com.chaozhou.xiaokechelib.page;

import com.chaozhou.lib.net.http.HttpClientHelper;

public abstract class BasePage<T> implements XiaokechePage<T> {
	protected HttpClientHelper client;
	
	public BasePage(HttpClientHelper client){
		this.client = client;
	}
}
