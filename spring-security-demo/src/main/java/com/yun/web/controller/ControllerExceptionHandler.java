package com.yun.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yun.web.exception.UserNotExistsException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotException(UserNotExistsException ex){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("id",ex.getId());
        result.put("message",ex.getMessage());
        return result;
    }
}