/*
 * lo primero que necesita spring para validar un formulario es que el modelo que le vamos a pasar 
 * disponga de ciertas anotaciones en sus atributos
 * 
 * 
 * 
 * 
 * 
 */

 package com.demo.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Persona {
	
	/******************************************************************************************************************/
	/*******************************************	VALIDACIONES DE FORMULARIO	***************************************/
	/******************************************************************************************************************/
	// ATRIBUTOS
	// @NotNull --> anotacion de spring para validar que un atributo no sea null
	// @Size --> anotacion de spring para validar la longitud de caracteres min: minimo max:maximo
	// @Min(18) --> anotacion de spring para validar el valor minimo admitido
	// hay que hacer tantan anotaciones como atributos
	
	// valido atributo nombre
	@NotNull
	@Size(min=2 , max=9)
	private String nombre;
	
	// valido atributo edad
	@NotNull
	@Min(18)
	private int edad;
	
	/******************************************************************************************************************/
	/******************************************************************************************************************/
	/******************************************************************************************************************/
	
	// constructor con todos los parametros
	public Persona( String nmb , int ed) {
		super();
		this.nombre =nmb;
		this.edad = ed;
	}
	
	// constructor sin parametros
	
	public Persona() { }
		
	// getters y setters
	
	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	

	
	
	
	
}
