package com.chaozhou.xiaokechelib;

public class WinResult {
	private String issueNo;
	private boolean isWin;
	
	public WinResult(String issueNo, boolean isWin) {
		super();
		this.issueNo = issueNo;
		this.isWin = isWin;
	}
	
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
	
	
}
