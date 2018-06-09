package com.natySpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.natySpring.constans.ConstantesVistas;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	@GetMapping("/formulariocontacto")
	public String redireccionarContactoFormulario() {		
		return ConstantesVistas.VISTA_FORMULARIO_CONTACTO;
	}

}
