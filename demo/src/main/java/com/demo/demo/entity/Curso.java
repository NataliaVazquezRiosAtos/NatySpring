package com.demo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// @Table relaciona el pojo con la tabla ;  en el caso de que se llamen igual no haria falta, pero lo ponemos igual

@Entity
@Table(name="curso")
public class Curso {
	
	// ATRIBUTOS
	
    @Id                     // se anota porque es un id
    @GeneratedValue         // hibernate se preocupa de generar el siguiente id
    @Column(name="idcurso") // esto indica la columna de la tabla en la base id es lo de la base    
    private int id;    

    @Column(name="nombre")  
    private String nombre;    

    @Column(name="descripcion") 
    private String descripcion;    

    @Column(name="precio")
    private int precio;   

    @Column(name="horas") 
    private int horas;	  
    
    // CONTRUCTORES 
    // obligatoriamente hat que generar un constructor vacio porque es el que llama hibernate
    
    public Curso() {}

	public Curso(int id, String nombre, String descripcion, int precio, int horas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.horas = horas;
	}
	
    // GETTERS Y SETTERS 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}  

}

