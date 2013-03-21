package com.chaozhou.lib.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

class HttpTextResponser extends HttpResponser<String> {

	public HttpTextResponser(HttpResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getResponse() throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		String html = "";
		InputStream in = response.getEntity().getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder str = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			str.append(line);
		}
		in.close();
		html = str.toString();
		return html;
	}
}
