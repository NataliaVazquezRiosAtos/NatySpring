package com.demo.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final String VISTA_CURSOS = "cursos";
	public static final Log MI_LOG = LogFactory.getLog(ControllerCurso.class);
	
	@Autowired
	@Qualifier("servicioCursoImplementado")
	private ServicioCurso miServicioCurso;
	
	@GetMapping("/listadocursos")
	public ModelAndView listarCursos() {
		MI_LOG.info(" Se ha llamado al metodo: listarCursos() ");
		ModelAndView mv = new ModelAndView(VISTA_CURSOS);
		// objeto vacio con el que thymeleaf pueda trabajar en el formulario ( en el formulario th:objest=${curso})
		mv.addObject("listado" , miServicioCurso.listadoCursos());
		mv.addObject("curso" , new Curso());
		
		return mv;		
	}
	
	@PostMapping("/anadircurso")
	public String anadirCurso(@ModelAttribute("curso") Curso curso) {	
		MI_LOG.info("Se ha llamado al metodo: anadirCurso() -- Parametros:  " + curso.toString() );
		miServicioCurso.anadirCurso(curso);
		return "redirect:/cursos/listadocursos";		
	}
	
	@PostMapping("/borrarcurso")
	public String borrarCurso(@ModelAttribute("curso") Curso curso) {
		
		//listarCursos();
		
		MI_LOG.info("Se ha llamado al metodo: borrarCurso() -- Parametros:  " + curso.toString() );
	
		miServicioCurso.borrarCurso(curso.getId());
		return "redirect:/cursos/listadocursos";		
	}
	
	@PostMapping("/actualizarcurso")
	public String modificarCurso(@ModelAttribute("curso") Curso curso) {	
		MI_LOG.info("Se ha llamado al metodo: modificarCurso() -- Parametros:  " + curso.toString() );
		miServicioCurso.modificar(curso);
		return "redirect:/cursos/listadocursos";		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
