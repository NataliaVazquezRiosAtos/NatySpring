package com.natySpring.converters;

import org.springframework.stereotype.Component;

import com.natySpring.entity.Contacto;
import com.natySpring.model.ContactoModelo;

@Component("contactoConverter")
public class ContactoConverter {

	public Contacto converterContactoModelo2Contacto(ContactoModelo contactoModelo) {
		
		Contacto contacto = new Contacto();
		contacto.setId(contactoModelo.getId());
		contacto.setNombre(contactoModelo.getNombre());
		contacto.setApellido(contactoModelo.getApellido());
		contacto.setTelefono(contactoModelo.getTelefono());
		contacto.setCiudad(contactoModelo.getCiudad());

		return contacto;
	}

	public ContactoModelo converterContacto2ContactoModelo(Contacto contacto) {
		
		ContactoModelo contactoModel = new ContactoModelo();
		contactoModel.setId(contacto.getId());
		contactoModel.setNombre(contacto.getNombre());
		contactoModel.setApellido(contacto.getApellido());
		contactoModel.setTelefono(contacto.getTelefono());
		contactoModel.setCiudad(contacto.getCiudad());

		return contactoModel;
	}

}
