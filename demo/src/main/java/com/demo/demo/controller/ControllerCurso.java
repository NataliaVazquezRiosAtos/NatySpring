package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.demo.entity.Curso;
import com.demo.demo.service.ServicioCurso;

@Controller
@RequestMapping("/cursos")

public class ControllerCurso {
	
	private static final String VISTA_CURSOS = "listadocursos";
	
	@Autowired
	@Qualifier("servicioCursoImplementado")
	private ServicioCurso miServicioCurso;
	
	@GetMapping("/listadocursos")
	public ModelAndView listarCursos() {
		ModelAndView mv = new ModelAndView(VISTA_CURSOS);
		mv.addObject("listado" , miServicioCurso.listadoCursos());
		return mv;		
	}
	
	@PostMapping("/anadircurso")
	public String anadirCurso(@ModelAttribute("curso") Curso curso) {		
		miServicioCurso.anadirCurso(curso);
		return "redirect:/listadocursos";		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
