package com.yun.security.core.properties;

public class BrowserProperties {
	
	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	private String loginPage = "/login.html";
	
	private LoginType loginType = LoginType.JSON;
	
	public int rememberMeSeconds =3600;
	
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}	
}
