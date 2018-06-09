/*
 * esta clase va a hacer que por cada peticion http que nos hagan entre por esta clase a traves de los siguiemtes metodos
 * sobreescritos ( heredados de la clase HandlerInterceptorAdapter ) 
 * 
 * para calcular el tiempo y mostrarlo en el log : 
 * 
 * */
package com.natySpring.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInerceptor")
public class Peticiones_HTTP_Time extends HandlerInterceptorAdapter{
	
	public static final Log MI_LOG = LogFactory.getLog(Peticiones_HTTP_Time.class);
	
	// PRIMERO
	// es el que se ejecuta justo antes de presentar la vista en el navegador ( antes del return )
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
		
	}	
	
	// SEGUNDO
	// es el metodo que se ejecuta antes de entrar en el metodo del controlador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {	
		
		long startTiempo = (long) request.getAttribute("startTime"); 
	
		MI_LOG.info("-- Respuesta URL: "+ request.getRequestURL().toString() + " -- TIEMPO TOTAL: " +( System.currentTimeMillis() - startTiempo)+"´ms");
		
	}		
	
}
