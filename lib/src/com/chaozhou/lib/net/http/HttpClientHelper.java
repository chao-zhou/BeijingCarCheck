package com.chaozhou.lib.net.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;

public class HttpClientHelper {

	private HttpClient client = new DefaultHttpClient();
	
	public String get(String uri) 
			throws IllegalStateException,IOException {
		
		HttpGetRequester req = new HttpGetRequester(uri);
		HttpResponse response = client.execute(req.getRequest());
		HttpTextResponser res = new HttpTextResponser(response);
		return res.getResponse();
	}
	
	public Bitmap getBitmap(String uri)
			throws IllegalStateException, IOException {
		
		HttpGetRequester req = new HttpGetRequester(uri);
		HttpResponse response = client.execute(req.getRequest());
		HttpBitmapResponser res = new HttpBitmapResponser(response);
		return res.getResponse();
	}

	public String postString(String uri, String value)
			throws IllegalStateException, IOException {

		HttpPostRequester req = new HttpPostRequester(uri,value);
		HttpResponse response = client.execute(req.getRequest());
		HttpTextResponser res = new HttpTextResponser(response);
		return res.getResponse();
	}
	
	public void Refresh(){
		client = new DefaultHttpClient();
	}
}
