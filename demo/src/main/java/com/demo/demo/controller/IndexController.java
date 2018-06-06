package com.demo.demo.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.demo.components.Ejemplo_Componente_1;
import com.demo.demo.model.Persona;
import com.demo.demo.service.PrimerServicio;


//@Controller :  anotación para que sea un bean de spring
@Controller
@RequestMapping("/casca")
public class IndexController {
	
	/*****************************************************************************************************/
	/************************************	CREAR UN SERVICIO	******************************************/
	/*****************************************************************************************************/
	@Autowired	
	@Qualifier("ejemploServicio")
	
	// se declara la interface , no la clase
	private PrimerServicio miServicio;
	
	/*****************************************************************************************************/
	/************************************	CREAR UN COMPONENTE	******************************************/
	/*****************************************************************************************************/
	
	// vamos a inyectar un componente creado por nosotros para ello: @Autowired
	@Autowired
	
	// @Qualifier indica a Spring el nombre del bean que se almacena en memoria 
	@Qualifier("componente_de_ejemplo")
	
	// ya listo para usar
	private Ejemplo_Componente_1 miComponente;
	
	/*****************************************************************************************************/
	/*****************************************************************************************************/
	/*****************************************************************************************************/
	
	// index2 = nombre de la vista	
	public static final String VISTA = "index2";

	@GetMapping("/index2")
	public String holaMundo(Model model) {	
		
		// para meterle un valor a la variable nombreDeMiVariable, definida en la vista index2
		// model.addAttribute("person" , new Persona ("Julio" , 80));	
		// model.addAttribute("nombreDeMiVariable" ,"perro");			
		miComponente.ver();
		model.addAttribute("listado" , miServicio.getListaPersonas());	
		
		return VISTA;
		
	}
	
	@GetMapping("/index2MAV")
	public ModelAndView ejemploMAV() {	
		
		// para meterle un valor a la variable nombreDeMiVariable, definida en la vista ind		
		ModelAndView mov = new ModelAndView(VISTA);
		//mov.addObject("nombreDeMiVariable" ,"gato");		
		//mov.addObject("person" , new Persona ("Carlos" , 50));
		
		mov.addObject("listado" , miServicio.getListaPersonas() );
		
		// return new ModelAndView(VISTA);
		return mov;
		
	}
	
	
	
}
