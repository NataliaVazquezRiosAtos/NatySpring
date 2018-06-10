package com.natySpring.services;
import java.util.List;

import com.natySpring.entity.Contacto;
import com.natySpring.model.ContactoModelo;

/*
 * creamos un servicio para que gestione toda la logica de gestionar un contacto
 * 
 * */

public interface ServiciosContacto {
	
	public abstract ContactoModelo anadirContacto(ContactoModelo contactoModelo);
	public abstract List<ContactoModelo> listarContactos();
	public abstract Contacto findById(int id);
	public abstract void borrarContacto(int id);
	public abstract ContactoModelo findByIdModelo(int id);

}
