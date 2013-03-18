package com.chaozhou.xiaokeche.net;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

import com.chaozhou.lib.HttpUtil;
import com.chaozhou.xiaokeche.utils.SettingsUtil;

public class RequetSender {

	private static String QueryURL = "http://apply.bjhjyd.gov.cn/apply/norm/personQuery.html";
	private static String ValidCodeURL = "http://apply.bjhjyd.gov.cn/apply/validCodeImage.html?ee=1";
	private Context mContext = null;

	public RequetSender(Context context) {
		mContext = context;
	}

	public String search(GregorianCalendar calendar, String validCode)
			throws IllegalStateException, IOException {

		SearchParam param = new SearchParam();
		param.setIssueNo(calendar);
		param.setApplyCode(SettingsUtil.getApplyCode(mContext));
		param.setValidCode(validCode);

		return HttpUtil.postString(QueryURL, param.toString());
	}

	public BitmapDrawable getValidCode() throws IllegalStateException,
			IOException {
		return HttpUtil.getBitmap(ValidCodeURL);
	}

	class SearchParam {
		private int pageNo = 1;
		private String issueNo = "";
		private String applyCode = "";
		private String validCode = "";

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		public String getIssueNo() {
			return issueNo;
		}

		public void setIssueNo(String issueNo) {
			this.issueNo = issueNo;
		}

		public void setIssueNo(GregorianCalendar calendar) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			issueNo = format.format(calendar.getTime());
		}

		public String getApplyCode() {
			return applyCode;
		}

		public void setApplyCode(String applyCode) {
			this.applyCode = applyCode;
		}

		public String getValidCode() {
			return validCode;
		}

		public void setValidCode(String validCode) {
			this.validCode = validCode;
		}

		@Override
		public String toString() {
			return "pageNo=" + String.valueOf(pageNo) + "&issueNumber="
					+ issueNo + "&applyCode=" + applyCode + "&validCode="
					+ validCode;
		}

	}

}
