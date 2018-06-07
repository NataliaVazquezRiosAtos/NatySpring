package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.demo.model.Persona;
import com.demo.demo.service.Servicio36;

@Controller
@RequestMapping("/ejercicio")
// @Component("requestTimeInerceptor")


public class Controller36 {
	
	@Autowired	
	@Qualifier("servicio36")
	
	// se declara la interface , no la clase
	private Servicio36 miServicio;
	
	private static final String VISTA = "index2";
	
	@GetMapping("/metodo1")
	public String medodo1(Model model) {		
		model.addAttribute("person", new Persona());
		miServicio.mensajeLog(); 
		return VISTA;
		
	}
	
	
	@GetMapping("/metodo2")
	public String metodo2(Model model) {		
		
		return medodo1(model);	
		 
		
	}

}
