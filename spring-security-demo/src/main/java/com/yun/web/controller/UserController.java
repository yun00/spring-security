package com.yun.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yun.dto.*;
import com.yun.web.exception.UserNotExistsException;
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/me")
	public Object getCurrentUser(Authentication authentication){
		return authentication;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id){
		System.out.println(id);
	}
	
	@GetMapping("{id:\\d+}")
	public User query() throws Exception{
		User user= new User();
		user.setUsername("yun");
		user.setBirthday(new Date());
		user.setPassword("123456");
		return user;
	}
	
	@PutMapping("{id:\\d+}")
	public User update(@Valid @RequestBody User user,BindingResult errors){
		if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error -> 
			{
				FieldError fieldError =(FieldError)error;
				String message =fieldError.getField()+" "+ error.getDefaultMessage();
				System.out.println(message);
			}
			);
		}
		
		return user;
	}
}
