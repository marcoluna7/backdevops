package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
	public static final String ERR_VIEW= "error/500";
	@ExceptionHandler(Exception.class)
	public String showInternalServerError()
	{
		return ERR_VIEW;
	}

}
