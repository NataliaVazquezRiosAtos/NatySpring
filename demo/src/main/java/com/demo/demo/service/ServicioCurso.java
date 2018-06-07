package com.demo.demo.service;

import java.util.List;

import com.demo.demo.entity.Curso;

public interface ServicioCurso {
	
	public abstract List <Curso>listadoCursos();
	public abstract Curso anadirCurso(Curso curso);
	public abstract int borrarCurso(int identtificador);
	public abstract Curso modificar(Curso curso);

}
