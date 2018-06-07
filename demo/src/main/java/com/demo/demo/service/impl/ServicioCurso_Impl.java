package com.demo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.demo.entity.Curso;
import com.demo.demo.repository.CursoJpaRepository;
import com.demo.demo.service.ServicioCurso;

public class ServicioCurso_Impl implements ServicioCurso {
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository jpaRepositoryCurso;

	@Override
	public List<Curso> listadoCursos() {
		
		return jpaRepositoryCurso.findAll();
	}

	@Override
	public Curso anadirCurso(Curso curso) {
		
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
