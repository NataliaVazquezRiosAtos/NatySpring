package com.natySpring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.natySpring.constans.ConstantesVistas;
import com.natySpring.model.CredencialesUsuario;

@Controller
public class LoginController {
	
	private static final Log MI_LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/") 
	public String redireccionarALogin() {	
		MI_LOG.info("-- ENTRA EN METODO: redireccionarALogin()");
		return "redirect:login";
	}
	
	// ponemos @RequestParam para recoger el parametro error en el caso de que alguna de las credenciales sea incorrecta
	@GetMapping("/login") 
	public String verFormularioLogin(
										Model model , 
										@RequestParam(name="error" , required=false) String error , 
										@RequestParam(name="logout" , required=false) String logout	
										
									) {		
		
		MI_LOG.info("-- ENTRA EN METODO: verFormularioLogin()  --   PARAMETROS: error=" + error + " , logout=" + logout);
		
		model.addAttribute("error" , error);
		model.addAttribute("logout" , logout);	
		model.addAttribute("credencialesFormulario" , new CredencialesUsuario());	
		
		MI_LOG.info("-- RETORNANDO A LA VISTA DE LOGIN");
		
		return ConstantesVistas.VISTA_LOGIN;
	}
	
	// credencialesFormulario es el atributo que recibimos del formulario
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute(name="credencialesFormulario") CredencialesUsuario credencialesUsuForm) {		
		
		MI_LOG.info("-- ENTRA EN METODO: checkLogin()  --   PARAMETROS: " + credencialesUsuForm);
		
		if(credencialesUsuForm.getNombreUsuario().equals("user") && credencialesUsuForm.getPassUsuario().equals("user")) {
			
			MI_LOG.info("-- RETORNANDO A LA VISTA DE CONTACS");
			// si el usuario y pass son correctas ( = user ), nos lleva a la vista de contactos
			return ConstantesVistas.VISTA_CONTACTOS;
			
			
		}else {
			
			// si el usuario o la pass son incorrectas ( != user ), nos redirecciona a la vista del formulario de login
			// y nos pasa como parametro el error
			MI_LOG.info("-- RETORNANDO A LA VISTA DE LOGIN POR ERROR DE USUARIO O CONTRASEÑA");
			return "redirect:/login?error";
			
		}		
		
	}	
	
}
