/*
 * en los servicios se incluye toda la logica de la aplicacion,
 *  
 * el controller es el que llama a servicios
 * 
 * hay que inyectarlo en el controller , en este caso en el IndexController
 * 
 * 
 * */

package com.demo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.demo.model.Persona;
import com.demo.demo.service.PrimerServicio;

@Service("ejemploServicio")
public class PrimerServicio_Impl implements PrimerServicio{
	
	public static final Log MI_LOG = LogFactory.getLog(PrimerServicio_Impl.class);

	@Override
	public List<Persona> getListaPersonas() {
		
	 	List<Persona> listaPersonas = new ArrayList<>();
	 	listaPersonas.add(new Persona("juan" , 23));
	 	listaPersonas.add(new Persona("ricardo" , 36));
	 	listaPersonas.add(new Persona("manuel" , 42));
	 	MI_LOG.info(" -----  hola desde sevice PrimerSeervicio_Impl  -----");
	 
	 	return listaPersonas;
	 	
	}

}
