package com.demo.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.stereotype.Controller;

@Controller
@ControllerAdvice
public class ControllerErrores {
	
	public static final String VISTA_ERROR_INTERNO_DEL_SERVODOR  = "ERROR/500";

	@ExceptionHandler(Exception.class)
	public String devuelveVistaErrorInternoServidor(){
		
		return VISTA_ERROR_INTERNO_DEL_SERVODOR;
		
		
	}
}
