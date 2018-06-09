package com.demo.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import com.demo.demo.entity.Curso;
import com.demo.demo.entity.QCurso;


@Repository("queryDSLEjemplRepo")
public class QueryDSLEjemploRepo {	
	
	// http://www.querydsl.com
		
	// si tenemos en problema que no nos encuentra la clase QCurso es porque la clase que ha generado no pertenea a los
	// recursos del proyecto, para solucionarlo:
	// 	1. 	desde cmd dentro de la carpeta del proyecto: mvn eclipse:eclipse
	// 		esto lo que hace, es que los recursos que ha autogenerado, nos los meta en los recursos de nuestra aplicacion y que no sean 
	// 		externos
	//  2. 	si el paso anterior no funciona probamos desde eclipse:
	// 		sobre nuestro proyecto *boton derecho *maven *update proyect
		
	
	// en todos los proyectos en los que utilicemos QueryDSL, se necesita declarar todas las 'clases Q' que nos ha autogenerado
	// para ello :
	// QnombreDeLaEntidad
	
	QCurso qCurso = QCurso.curso;	
	
	// en todos los metodos en los que hagamos una consuta con QueryDSL enemos que utilizar la clase JPAQuery<T>
	// la 'T' hay que substituirla por la entidad con la que vamos a trabajar
	// nos va a pedir como parametro un EntityManager (no lo tenemos )
	// EntityManager es un objeto que se encarga de la persistencia de la aplicacion, de gestionar las entidades
	// de la persistencia de la aplicacion
	// para obtenerlo:
	
	@PersistenceContext
	private EntityManager em;
	
	public Curso find(boolean existe){
		
		JPAQuery<Curso> q = new JPAQuery<Curso>(em);
		BooleanBuilder pb = new BooleanBuilder(qCurso.descripcion.endsWith("OP"));
		
		if(existe) {		
			
			// el objeto que admite el where de la consulta es un predicate
			
			Predicate p1 = qCurso.id.eq(23);
			pb.and(p1);		
			
		}else {
			
			Predicate p2 = qCurso.nombre.endsWith("OP");
			pb.or(p2);
			
		}
		
		return q.select(qCurso).from(qCurso).where(pb).fetchOne();		
		
		// q.select(qCurso).from(qCurso).where(qCurso.id.eq(1)) --> para la consulta		
		// .fetchOne() --> para que nos devuelva el dato
		// Curso curso = q.select(qCurso).from(qCurso).where(qCurso.id.eq(1)).fetchOne();
		
		// si solo nos hicieran falta las columnas de nombre y descripcion
		// Curso curso2 = (Curso) q.select(qCurso.nombre,qCurso.descripcion).from(qCurso).where(qCurso.id.eq(1)).fetchOne();
		
		// consuta que nos devuelve los cursos que tengan de 30 a 50 horas
		// nos devuelve un listado		
		// List<Curso> listaCursos =  q.select(qCurso).from(qCurso).where(qCurso.horas.between(20, 50)).fetch();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 

}
