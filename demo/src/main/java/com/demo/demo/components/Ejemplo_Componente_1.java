package com.demo.demo.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.demo.demo.controller.ControllerFormulario;
import com.demo.demo.repository.CursoJpaRepository;

@Component("componente_de_ejemplo")
public class Ejemplo_Componente_1 {
	
	private final Log MI_LOG = LogFactory.getLog(Ejemplo_Componente_1.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository jpaRepositoryCurso;
	
	public void ver() {
		
		MI_LOG.info("hola desde Ejemplo_Componente_1");		
		
	}

}
