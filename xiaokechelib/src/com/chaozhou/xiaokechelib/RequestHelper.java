package com.chaozhou.xiaokechelib;

import java.io.IOException;
import java.util.GregorianCalendar;

import android.graphics.Bitmap;
import android.util.Log;

import com.chaozhou.lib.net.http.HttpClientHelper;
import com.chaozhou.xiaokechelib.page.ProfilePage;
import com.chaozhou.xiaokechelib.page.ProfilePageParam;
import com.chaozhou.xiaokechelib.page.ValidCodePage;
import com.chaozhou.xiaokechelib.page.WinResultPage;
import com.chaozhou.xiaokechelib.page.WinResultPageParam;


public class RequestHelper {
	
	private HttpClientHelper client = new HttpClientHelper();
	
	public Bitmap getValidCodeBitmap() throws IllegalStateException, IOException{
		ValidCodePage page = new ValidCodePage(client);
		return page.getPage();
	}
	
	public String getWinResult(GregorianCalendar calendar,String applyCode, String validCode) throws IllegalStateException, IOException{
		WinResultPageParam param = new WinResultPageParam();
		param.setIssueNo(calendar);
		param.setApplyCode(applyCode);
		param.setValidCode(validCode);
		
		WinResultPage page = new WinResultPage(client,param);
		return page.getPage();
	}
	
	public String login(String validcode) throws IllegalStateException, IOException{
		ProfilePageParam param = new ProfilePageParam();
		param.setPhone("18600406362");
		param.setPassword("841111");
		param.setValidCode(validcode);
		
		Log.v("html", client.getCookieString());
		
		return new ProfilePage(client,param).getPage();
	}
	
	
	
	public void getProfilePage(){
		
	}
	
	
}
