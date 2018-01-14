package com.yun.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yun.security.core.properties.LoginType;
import com.yun.security.core.properties.SecurityProperties;

@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private LoginType loginType = LoginType.JSON;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//Authentication接口封装认证信息
		
		logger.info("登录成功");
		
		if(loginType.equals(securityProperties.getBrowser().getLoginType())){
			response.setContentType("application/json;charset=UTF-8");
			
			//将authentication认证信息转换为json格式的字符串写到response里面去
			response.getWriter().write(objectMapper.writeValueAsString(authentication));
		}
		else{
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
