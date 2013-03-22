package com.chaozhou.xiaokechelib.page;

import java.io.IOException;

import android.util.Log;

import com.chaozhou.lib.net.http.HttpClientHelper;
import com.chaozhou.lib.net.http.HttpUtil;

public class ProfilePage extends BasePage<String> {

	private ProfilePageParam param = null;
	
	private String postUri = "http://apply.bjhjyd.gov.cn/apply/enterprise/login.html";
	private String profileUri = "http://apply.bjhjyd.gov.cn/apply/person/print.do#none";
	
	public ProfilePage(HttpClientHelper client,ProfilePageParam param) {
		super(client);
		// TODO Auto-generated constructor stub
		
		this.param = param;
	}

	@Override
	public String getPage() throws IllegalStateException, IOException {
		// TODO Auto-generated method stub	
		Log.v("html", param.toString());
		return client.get(profileUri);
	}

}
