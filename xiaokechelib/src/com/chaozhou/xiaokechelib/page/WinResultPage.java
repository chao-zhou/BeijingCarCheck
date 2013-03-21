package com.chaozhou.xiaokechelib.page;

import java.io.IOException;

import com.chaozhou.lib.net.http.HttpClientHelper;

public class WinResultPage extends BasePage<String> {

	private static String URI = "http://apply.bjhjyd.gov.cn/apply/norm/personQuery.html";
	private WinResultPageParam postParam;
	
	public WinResultPage(HttpClientHelper client,WinResultPageParam param){
		super(client);
		postParam = param;
	}
	
	
	@Override
	public String getPage() throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		return client.postString(URI, postParam.toString());
	}
}
