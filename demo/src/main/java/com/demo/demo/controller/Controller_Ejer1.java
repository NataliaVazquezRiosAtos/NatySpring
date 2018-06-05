package com.demo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ejercicios")
public class Controller_Ejer1 {
	
	public static final String VISTA_EJERCICIO_11= "404";
	
	@GetMapping("ejer1")
	public String devolverVista(Model model) {
		
		return VISTA_EJERCICIO_11;
	}
	
	

}
