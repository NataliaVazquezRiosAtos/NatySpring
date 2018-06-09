package com.natySpring.services;

import com.natySpring.entity.Contacto;
import com.natySpring.model.ContactoModelo;

/*
 * creamos un servicio para que gestione toda la logica de gestionar un contacto
 * 
 * */

public interface ServiciosContacto {
	
	public abstract ContactoModelo anadirContacto(ContactoModelo contactoModelo);

}
