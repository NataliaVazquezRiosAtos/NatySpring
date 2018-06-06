package com.demo.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demo.demo.components.Peticiones_HTTP_Time;

@Configuration
public class ConfigurationWebMvc_Mod extends WebMvcConfigurerAdapter {
	
	// le decimos a spring que se encuentra en su memoria
	@Autowired
	@Qualifier("requestTimeInerceptor")
	
	private Peticiones_HTTP_Time requestTime;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(requestTime);
		
	}

	
}
