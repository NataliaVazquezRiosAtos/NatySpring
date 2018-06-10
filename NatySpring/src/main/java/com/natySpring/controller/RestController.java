package com.natySpring.controller;

/*
 * RestController no nos devuelve una vista , simplemente nos devuelve datos
 * 
 * Estos RestController , suelen utilizarse cuando el cliente se encarga de integrar las plantillas
 * 
 * */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.natySpring.model.ContactoModelo;

// anotacion de RestController
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	// devuelve un JSON, por eso ResponseEntity<>
	@GetMapping("/prueba")	
	public ResponseEntity<String> checkRest(){
		
		return new ResponseEntity<String>("ok!", HttpStatus.OK);
		
	} 
	
	@GetMapping("/contactomodelo")	
	public ResponseEntity<ContactoModelo> checkRes2t(){
		ContactoModelo cm = new ContactoModelo(4, "carlos", "lopez", "666666", "lugo");
		return new ResponseEntity<ContactoModelo>(cm , HttpStatus.OK);
		
	}	

}
