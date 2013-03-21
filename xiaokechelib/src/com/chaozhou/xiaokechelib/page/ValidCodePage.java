package com.chaozhou.xiaokechelib.page;

import java.io.IOException;

import com.chaozhou.lib.net.http.HttpClientHelper;

import android.graphics.Bitmap;

public class ValidCodePage extends BasePage<Bitmap> {

	public ValidCodePage(HttpClientHelper client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

	private static String URI = "http://apply.bjhjyd.gov.cn/apply/validCodeImage.html?ee=1";
	
	@Override
	public Bitmap getPage() throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		return client.getBitmap(URI);
	}

}
