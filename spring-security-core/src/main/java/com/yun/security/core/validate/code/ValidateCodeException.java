package com.yun.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException{

	private static final long serialVersionUID = -3293874279425052878L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
