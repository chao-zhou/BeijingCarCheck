package com.chaozhou.xiaokechelib;

import java.util.GregorianCalendar;

public class User {
	private String name;
	private String applyCode;
	private String id;
	private String pwd;
	private GregorianCalendar endCalendar;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public GregorianCalendar getEndCalendar() {
		return endCalendar;
	}
	public void setEndCalendar(GregorianCalendar endCalendar) {
		this.endCalendar = endCalendar;
	}
	
	
	public static User CreaetByNumber(String issueNo, String password){
		User u  = new User();
		u.setApplyCode(issueNo);
		u.setPwd(password);
		return u;
	}
	
	public static User CreaetById(String id, String password){
		User u  = new User();
		u.setId(id);
		u.setPwd(password);
		return u;
	}
	
}
