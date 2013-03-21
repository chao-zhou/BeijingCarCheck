package com.chaozhou.xiaokechelib.analysis;

import java.security.InvalidParameterException;

public class WinResultAnalysis extends TextAnalysis{

	private String applyCode;
	
	public WinResultAnalysis(String applyCode){
		this.applyCode = applyCode;
	}
	
	public boolean analysis(String html){
		if(applyCode.length()<1){
			throw new InvalidParameterException("IssueNo should not be empty");
		}
		
		return html.contains(applyCode);
	}
}
