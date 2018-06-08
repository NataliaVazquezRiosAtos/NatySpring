package com.demo.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demo.entity.Curso;

/*
 * los repositorios sirven para hacer las querys
 * esta interface nos permite también, poder crear metodos personalizados que sigan una logica que JpaRepository
 * acepte , el cual no nos haga falta ningun tipo de implementacion ( es una interfaz )
 * 
 * */

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable> {
	
	// solo con las dos lineas anteriores esto ya tendriamos un repositorio jpa
	// JpaRepository<Curso, Serializable>    Curso --> entidad a la que va a hacer referencia
	
	// public abstract Curso metodo();
	
	// JpaRepository nos permite realizar las siguientes querys : 
	// findByNombre : hace una query por el atributo nombre del bean Curso sin implementar nada
	// se podria hacer para cada uno de los atributos del bean : findByDescripcion ,findByPrecio , etc...
	
	public abstract Curso findByNombre(String nombre);
	
	// tambien se pueden hacer consultas compueastas :
	// hace una query por los dos atributos sin necesidad e implementar nada
	
	public abstract Curso findByNombreAndDescripcion( String nombre , String descripcion );
	
	// hace una query por nombre ordenandolos por numero de horas , sin necesidad e implementar nada
	
	public abstract List<Curso> findByNombreOrderByHoras (String nombre);
	
	// hace una query por los dos atributos sin necesidad e implementar nada
	
	public abstract List<Curso> findByNombreOrPrecio (String nombre, int precio);
	

}


























