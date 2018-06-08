package com.demo.demo.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.demo.demo.entity.Curso;
import com.demo.demo.repository.CursoJpaRepository;
import com.demo.demo.service.ServicioCurso;

@Service("servicioCursoImplementado")
public class ServicioCurso_Impl implements ServicioCurso {
	
	public static final Log MI_LOG = LogFactory.getLog(ServicioCurso_Impl.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository jpaRepositoryCurso;

	@Override
	public List<Curso> listadoCursos() {
		MI_LOG.info(" Se ha llamado al metodo listadoCursos()"); 		
		return jpaRepositoryCurso.findAll();
	}

	@Override
	public Curso anadirCurso(Curso curso) {
		MI_LOG.info(" Se ha llamado al metodo anadirCurso(Curso curso)"); 
		return jpaRepositoryCurso.save(curso);
	}

	@Override
	public int borrarCurso(int codigo) {	
		jpaRepositoryCurso.deleteById(codigo);
		return 0;
	}

	@Override
	public Curso modificar(Curso curso) {		
		return jpaRepositoryCurso.save(curso);
	}

}
