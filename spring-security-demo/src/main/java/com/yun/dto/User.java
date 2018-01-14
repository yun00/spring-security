package com.yun.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonView;
import com.yun.validator.MyConstraint;

public class User {
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date date) {
		this.birthday = date;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String username;
	
	private String password;
	
	private Date birthday;

}
