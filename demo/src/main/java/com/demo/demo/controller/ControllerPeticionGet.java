package com.demo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/peticionGet")
public class ControllerPeticionGet {
	
	private static final String VISTA = "index3";
	
	// localhost:8080/peticionGet/respuesta1?nm=rodrigo
	// localhost:8080/peticionGet/respuesta1?nm=jorge
	
	@GetMapping("/respuesta1")
	public ModelAndView respuestaGet1(@RequestParam(name="nm" , required=false , defaultValue="sin datos") String name) {
		// required = false  --> para que no casque si no se le pasan valores ; por defecto está a true
		// defaultValue = "sin datos" --> le ponemos un valor por defecto en el caso de que no se le pasen parametros
		ModelAndView mov = new ModelAndView(VISTA);
		mov.addObject("nm_in_model", name);
		
		return  mov;		
		
	}
	
	// localhost:8080/peticionGet/respuesta2/rodrigo
	// localhost:8080/peticionGet/respuesta2/jorge
	
	@GetMapping("/respuesta2/{nm}")
	public ModelAndView respuestaGet2(@PathVariable("nm") String name) {

		ModelAndView mov = new ModelAndView(VISTA);
		mov.addObject("nm_in_model", name);
		
		return  mov;		
		
	}
	
	

}
