package com.natySpring.services.impl;

import com.natySpring.model.ContactoModelo;
import com.natySpring.repository.ContactoRepositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.natySpring.converters.ContactoConverter;
import com.natySpring.entity.Contacto;
import com.natySpring.services.ServiciosContacto;

@Service("servicioComtactoImpl")
public class ServiciosContacto_Impl implements ServiciosContacto {
	private static final Log LOG = LogFactory.getLog(ServiciosContacto_Impl.class);
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

	@Override
	public List<ContactoModelo> listarContactos() {
		
		List<Contacto> listaContactos = contactoRepo.findAll();		
		List<ContactoModelo> listaContactosModelo = new ArrayList<ContactoModelo>();
		
		for (Contacto resultadoListaContactos : listaContactos) {
			
			listaContactosModelo.add(contactoConverter.converterContacto2ContactoModelo(resultadoListaContactos));
		}
		
		return listaContactosModelo;		

	}

	@Override
	public Contacto findById(int id) {
	
		return contactoRepo.findById(id);
	}
	
	@Override
	public ContactoModelo findByIdModelo(int id) {
		
		return contactoConverter.converterContacto2ContactoModelo(findById(id));
	
	}

	@Override
	public void borrarContacto(int id) {

		Contacto contacto = findById(id);
		
		if(null != contacto) {
			contactoRepo.delete(contacto);
		}
		
	}		

}
