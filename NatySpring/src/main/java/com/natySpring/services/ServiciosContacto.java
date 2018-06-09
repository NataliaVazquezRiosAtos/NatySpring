package com.natySpring.services;
import java.util.List;

import com.natySpring.model.ContactoModelo;

/*
 * creamos un servicio para que gestione toda la logica de gestionar un contacto
 * 
 * */

public interface ServiciosContacto {
	
	public abstract ContactoModelo anadirContacto(ContactoModelo contactoModelo);
	public abstract List listarContactos();

}
