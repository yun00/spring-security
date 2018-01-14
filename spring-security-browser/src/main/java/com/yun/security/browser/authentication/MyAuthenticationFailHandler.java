package com.yun.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yun.security.browser.support.SimpleResponse;
import com.yun.security.core.properties.LoginType;
import com.yun.security.core.properties.SecurityProperties;

@Component
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private LoginType loginType = LoginType.JSON;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		if(loginType.equals(securityProperties.getBrowser().getLoginType())){
			logger.info("登陆失败");
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
		}
		else{
			super.onAuthenticationFailure(request, response, exception);
		}

	}

}
