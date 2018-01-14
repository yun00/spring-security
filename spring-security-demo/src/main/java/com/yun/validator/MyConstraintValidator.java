package com.yun.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.yun.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private HelloService helloService;
	
	@Override
	public void initialize(MyConstraint arg0) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		helloService.greeting("tom");
		System.out.println(arg0);
		return false;
	}

}
