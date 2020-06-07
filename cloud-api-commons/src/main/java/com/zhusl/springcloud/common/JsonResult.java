package com.zhusl.springcloud.common;


import lombok.Data;

@Data
public class JsonResult<T> {
	
	private Integer code;
	private String message;
	private T data;
	
	
	
	public JsonResult(Integer code, String message) {
		this(code, message, null);
	}



	public JsonResult(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}



	public JsonResult() {
		super();
	}
	
	

}
