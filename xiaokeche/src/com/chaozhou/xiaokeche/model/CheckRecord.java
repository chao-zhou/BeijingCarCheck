package com.chaozhou.xiaokeche.model;

public class CheckRecord {

	private String issueNo = null;;
	private boolean isWin = false;

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	@Override
	public String toString() {
		String date = issueNo.substring(0, 3) + "-" + issueNo.substring(4, 5);
		String winStr = isWin ? "ÖÐÇ©" : "Ã»ÖÐ";
		return date + " " + winStr;
	}
}
