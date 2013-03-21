package com.chaozhou.xiaokechelib.page;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WinResultPageParam {
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
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM",Locale.US);
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