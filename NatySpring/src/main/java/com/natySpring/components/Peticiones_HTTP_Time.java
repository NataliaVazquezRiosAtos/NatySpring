/*
 * esta clase va a hacer que por cada peticion http que nos hagan entre por esta clase a traves de los siguiemtes metodos
 * sobreescritos ( heredados de la clase HandlerInterceptorAdapter ) 
 * 
 * para calcular el tiempo y mostrarlo en el log : 
 * 
 * */
package com.natySpring.components;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.natySpring.repository.LogRepositorio;

@Component("requestTimeInerceptor")
public class Peticiones_HTTP_Time extends HandlerInterceptorAdapter{
	
	@Autowired
	@Qualifier("repositorioLog")
	private LogRepositorio logRepo;
	
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
		
		// guardamos la url en un variable
		String url = request.getRequestURL().toString();
		
		// creamos el objeto autentificacion
		Authentication autenfificacion = SecurityContextHolder.getContext().getAuthentication();
		
		// crea mos variabble que guarda el nombre del ususario		
		String nombreUsuario = "";
		
		// comprobamos si esl usuario esta autentificaado
		if( null != autenfificacion && autenfificacion.isAuthenticated()) {
			
			// si el usuario esta autentificado guardamos su nombre de usario en la variable
			nombreUsuario = autenfificacion.getName();
			
		}		
	
		logRepo.save( new com.natySpring.entity.Log(new Date(), autenfificacion.getCredentials().toString(), nombreUsuario , url));
	
		MI_LOG.info(" -- Respuesta URL: "+ url  + " -- TIEMPO TOTAL: " +( System.currentTimeMillis() - startTiempo)+"´ms");
		
	}		
	
}
