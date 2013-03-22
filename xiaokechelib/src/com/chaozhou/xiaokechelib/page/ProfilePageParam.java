package com.chaozhou.xiaokechelib.page;

public class ProfilePageParam {
	private String[] types = new String[]{"MOBILE","APPLYCODE"}; 
	private String phone = null;
	private String applyCode = null;
	private String validCode = null;
	private String password = null;
		
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType(){
		if(applyCode != null)
			return types[1];
		
		return types[0];
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String value = "type=person" 
			    +"&password=" + getPassword()
			    +"&validCode=" + getValidCode()
			    +"&loginType="+ getType()
			    +"&grSelect=" + getType()
			    +"&qySelect=MOBILE"
			    +"&sySelect=MOBILE";
		
		if(applyCode != null){
		return  value +"&applyCode=" + getApplyCode();
		}
		
		return  value +"&mobile=" + getPhone();

	}
	
	//loginType=APPLYCODE&type=person&grSelect=APPLYCODE&applyCode=123&password=123&validCode=123&qySelect=MOBILE&sySelect=MOBILE

	
}
