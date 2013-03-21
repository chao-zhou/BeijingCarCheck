package com.chaozhou.xiaokechelib;

public abstract class RequestBasedHelper {
	protected RequestHelper reqHelper = null;
	
	public RequestBasedHelper(RequestHelper reqHelper)
	{
		this.reqHelper = reqHelper;
	}
}
