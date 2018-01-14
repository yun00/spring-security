package com.yun.security.core.social.qq;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class YunSpringSocialConfigurer extends SpringSocialConfigurer{
	
	private String filterProcessesUrl;
	
	public YunSpringSocialConfigurer(String filterProcessesUrl){
		this.filterProcessesUrl = filterProcessesUrl;
	}
	
	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		filter.setFilterProcessesUrl(this.filterProcessesUrl);
		return super.postProcess(object);
	}
}
