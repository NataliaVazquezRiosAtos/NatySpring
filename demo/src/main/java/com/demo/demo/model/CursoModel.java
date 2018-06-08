package com.demo.demo.model;

public class CursoModel {
	
	// atributos
	
	private String nombre;
	private String descripcion;
	private int horas;
	private int precio;	
		
	// constructores
	
	public CursoModel() {}
	
	public CursoModel(String nombre, String descripcion, int horas, int precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
		this.precio = precio;
	}
	
	// getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	// toString()
	
	@Override
	public String toString() {
		return "CursoModel [nombre=" + nombre + ", descripcion=" + descripcion + ", horas=" + horas + ", precio="
				+ precio + "]";
	}
	
	
	
	

}
