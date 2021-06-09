package com.YANG.BDQN_shop.exception;

/**
 * 
 * @author WLF
 *
 */
public class ServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3268921144470390770L;
	
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ServiceException(){
		
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	 public ServiceException(String message,Throwable e){
		super(message, e);
	}
}
