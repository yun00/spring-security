package com.yun.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties {
	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	private BrowserProperties browser = new BrowserProperties();

	private ValidateCodeProperties code= new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();
	
	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}
	
	public ValidateCodeProperties getCode() {
		return code;
	}
	
	
}
