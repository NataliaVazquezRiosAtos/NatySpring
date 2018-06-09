package com.natySpring.services.impl;

import com.natySpring.model.ContactoModelo;
import com.natySpring.repository.ContactoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.natySpring.converters.ContactoConverter;
import com.natySpring.entity.Contacto;
import com.natySpring.services.ServiciosContacto;

@Service("servicioComtactoImpl")
public class ServiciosContacto_Impl implements ServiciosContacto {
	
	// añadimos el repositorio
	@Autowired
	@Qualifier("repositorioContactos")
	// inicializamos el repositorio
	private ContactoRepositorio contactoRepo;
	
	// inyectamos componente
	@Autowired
	@Qualifier("contactoConverter")
	// inicializamos el contactoConverter
	private ContactoConverter contactoConverter;

	@Override
	public ContactoModelo anadirContacto(ContactoModelo contactoModelo) {
		Contacto contacto = contactoRepo.save(contactoConverter.converterContactoModelo2Contacto(contactoModelo));
		return contactoConverter.converterContacto2ContactoModelo(contacto);
	}	

}
