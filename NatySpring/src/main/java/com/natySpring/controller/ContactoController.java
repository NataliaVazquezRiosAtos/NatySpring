package com.natySpring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.natySpring.constans.ConstantesVistas;
import com.natySpring.model.ContactoModelo;
import com.natySpring.services.ServiciosContacto;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	// añadimos el servicio
	@Autowired
	@Qualifier("servicioComtactoImpl")
	
	// implementacion de la iunterfaz
	private ServiciosContacto servicioContacto;
	
	// creamos un log
	public static final Log MI_LOG = LogFactory.getLog(ContactoController.class);
	
	@GetMapping("/cancelar")
	public String cancelar() {
		MI_LOG.info(" -- ENTRA EN EL METODO: cancelar()");
		return "redirect:/contactos/vercontactos";
	}
	
	@GetMapping("/formulariocontacto")
	public String redireccionarContactoFormulario(Model model) {
		// le pasamos un modelo porque vamos a trabajar ContactoModelo(), no con la entity correspondiente ( Contacto ) 
		MI_LOG.info(" -- ENTRA EN EL METODO: redireccionarContactoFormulario()");
		model.addAttribute("contactoFormulario", new ContactoModelo());
		return ConstantesVistas.VISTA_FORMULARIO_CONTACTO;
	}
	
	@PostMapping("/anadircontacto")
	public String anadircontacto(@ModelAttribute(name="contactoFormulario") ContactoModelo contactoModelo , Model model) {
		
		MI_LOG.info("-- ENTRA EN METODO: anadircontact()  --   PARAMETROS: " + contactoModelo.toString());
		
		if(null != servicioContacto.anadirContacto(contactoModelo)) {
			model.addAttribute("resultado" , 1 );
		}else {
			model.addAttribute("resultado" , 1 );	
		}
		
		return "redirect:/contactos/vercontactos";
		
	}
	
	@GetMapping("/vercontactos")
	public ModelAndView verContactos() {
		
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_CONTACTOS);
		mav.addObject("miscontactos" , servicioContacto.listarContactos());
		
		return mav;
	}
	
}
