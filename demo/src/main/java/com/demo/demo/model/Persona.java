package com.demo.demo.model;

public class Persona {
	
	// atributos
	
	private String nombre;
	private int edad;	
	
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
