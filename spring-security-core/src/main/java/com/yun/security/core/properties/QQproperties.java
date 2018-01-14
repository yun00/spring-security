package com.yun.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

public class QQproperties extends SocialProperties{
	
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	private String providerId = "qq";
	
	
}
