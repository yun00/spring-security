package com.yun.security.core.properties;

public class SocialProperties {
	public String getFilterProcessesUrl() {
		return filterProcessesUrl;
	}

	public void setFilterProcessesUrl(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	public QQproperties getQq() {
		return qq;
	}

	public void setQq(QQproperties qq) {
		this.qq = qq;
	}

	private QQproperties qq = new QQproperties();
	
	private String filterProcessesUrl = "/auth";
}
