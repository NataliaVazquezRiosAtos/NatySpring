package com.natySpring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.natySpring.constans.ConstantesVistas;
import com.natySpring.model.ContactoModelo;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	public static final Log MI_LOG = LogFactory.getLog(ContactoController.class);
	
	@GetMapping("/cancelar")
	public String cancelar() {
		MI_LOG.info(" -- ENTRA EN EL METODO: cancelar()");
		return ConstantesVistas.VISTA_CONTACTOS;
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
		model.addAttribute("resultado" , 1 );
		return ConstantesVistas.VISTA_CONTACTOS;
		
	}
	
}
