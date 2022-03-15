package com.cos.blog.handler;

import java.nio.channels.IllegalChannelGroupException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 어디든 exception이 발생하면 들어온다.
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
	
	//추가 가능
//	@ExceptionHandler(value=Exception.class)
//	public String handleArgumentException(Exception e) {
//		return "<h1>"+e.getMessage()+"</h1>";
//	}
}
