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
		
		return ConstantesVistas.VISTA_LOGIN;
	}
	
	// se coge de ConfiguracionSeguridad .defaultSuccessUrl("/logincorrecto") -->
	@GetMapping({"/" , "/logincorrecto"}) 
	public String checkLogin() {		
		
		MI_LOG.info(" -- ENTRA EN METODO: checkLogin()");
		
		return "redirect:/contactos/vercontactos";
					
	}	
	
}
