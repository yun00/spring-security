package com.yun.web.exception;

public class UserNotExistsException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;

    public UserNotExistsException(String id){
        super("user not exist");
        this.id = id;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
}
