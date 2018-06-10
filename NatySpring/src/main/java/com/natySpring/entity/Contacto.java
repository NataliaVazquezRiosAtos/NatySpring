package com.natySpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Contacto.
 */
@Entity
@Table(name="contactos")
public class Contacto {
	
	// atributos
	/** The id. */
	// @GeneratedValue --> para que nos autogenere el id
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	/** The nombre. */
	@Column(name="nombre")
	private String nombre;
	
	/** The apellido. */
	@Column(name="apellido")
	private String apellido;
	
	/** The telefono. */
	@Column(name="telefono")
	private String telefono;
	
	/** The ciudad. */
	@Column(name="ciudad")
	private String ciudad;
	
	// constructores
	
	/**
	 * Instantiates a new contacto.
	 */
	public Contacto() {}
	
	/**
	 * Instantiates a new contacto.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param apellido the apellido
	 * @param telefono the telefono
	 * @param ciudad the ciudad
	 */
	public Contacto(int id, String nombre, String apellido, String telefono, String ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	
	// getters y setters
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	
	/**
	 * Sets the ciudad.
	 *
	 * @param ciudad the new ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	// toString()
	@Override
	public String toString() {
		
		String cadena = "****************************************************** \n";
		
		return 	cadena +
				"Contacto " + nombre + " : \n " +
				cadena +
				"Codigo : " + id + " \n " + 
				"Nombre : " + nombre + " \n " +
				"Apellido : " + apellido + " \n " +
				"Telefono : " + telefono + " \n " +
				"Ciudad : " + ciudad + " \n " +
				cadena
				;
	}	

}
