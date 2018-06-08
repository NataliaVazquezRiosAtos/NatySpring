package com.demo.demo.converters;

import org.springframework.stereotype.Component;

import com.demo.demo.entity.Curso;
import com.demo.demo.model.CursoModel;

/*
 * hay datos que estan en las tablas que no nos interesan enviar a los modelos
 * hasta ahora hemos trabajado con entitys, y lo ideal seria que los controldores trabajaran con modelos
 * para ello se utilizan los converters
 * se declaran coomo componentes
 * consta de dos metodos: 
 * 		1. va a transformar una entity a un modelo
 *  	2. va a transformar un modelo a una entity
 * */
@Component("cursoConverter")
public class CursoConverter {
	
	// 1. va a transformar una entity a un modelo
	
	public CursoModel entity2model (Curso curso) {
		
		CursoModel cursoModel = new CursoModel();
		
		cursoModel.setNombre(curso.getNombre());
		cursoModel.setDescripcion(curso.getDescripcion());
		cursoModel.setHoras(curso.getHoras());
		cursoModel.setPrecio(curso.getPrecio());
		
		return cursoModel;
	}
	
	// 2. va a transformar un modelo a una entity
	
	public Curso model2entity (CursoModel cursoModel) {
		Curso curso = new Curso();
		curso.setNombre(cursoModel.getNombre());
		curso.setDescripcion(cursoModel.getDescripcion());
		curso.setHoras(cursoModel.getHoras());
		curso.setPrecio(cursoModel.getPrecio());
		return curso;
		
	}
}
