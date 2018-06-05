package com.demo.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.demo.demo.model.Persona;

@Controller
@RequestMapping("/formular")

public class ControllerFormulario {
	
	public static final String VISTA_FORMULARIO = "formulario";
	public static final String VISTA_RESPUESTA_FORMULARIO = "respuesta_formulario";
	private final Log MI_LOG = LogFactory.getLog(ControllerFormulario.class);
	
	// para redireccionar --> ejemplo : el el caso de que pusieramos la url  localhost:8080/formular ; dos maneras :	
	// primera forma :
	/*
	@GetMapping("/")
	public String redireccionar() {
		return "redirect:/formular/form" ;
		
	}
	*/
	
	// segunda forma : mediante un objeto de spring
	
	@GetMapping("/")
	public RedirectView redireccionar() {
		return new RedirectView("/formular/form") ;
		
	}
	
	
	// ***************************************************************************************************************************
	// ***************************************************************************************************************************
	// ***************************************************************************************************************************
	
	
	
	// para enseñar el formulario
	@GetMapping("/form")
	public String verFormulario(Model model) {
		
		model.addAttribute("person", new Persona());		
		//int i  = 5/0;		
		return VISTA_FORMULARIO;
		
	}
	
	
	
	// @ModelAttribute --> para recoger los datos del formulario, una vez enviados
	// @ModelAttribute("person") Persona person
	// @ModelAttribute("person") --> nombre del atributo en la vista de formulario
	// Persona person --> person el el objeto de tipo Persona
	@PostMapping("/crearpersona")	
	public ModelAndView crearPersona(@ModelAttribute("person") Persona person) {
		MI_LOG.info("METODO: crearPersona() -- PARAMETROS: " + person);
		ModelAndView mav = new ModelAndView(VISTA_RESPUESTA_FORMULARIO);	
		mav.addObject("person" , person);
		return mav;			
	}	

}
