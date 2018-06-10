package com.natySpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Log.
 */
@Entity
@Table(name="log")
public class Log {
	
	// atributos
	
	/** The id log. */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int idLog;
	
	/** The fecha. */
	@Column(name="fecha")
	private Date fecha;
	
	/** The detalles. */
	@Column(name="detalles")
	private String detalles;
	
	/** The usuario. */
	@Column(name="usuario")
	private String usuario;
	
	/** The url. */
	@Column(name="url")
	private String url;

	// controladores
	
	/**
	 * Instantiates a new log.
	 */
	public Log() {}
	
	/**
	 * Instantiates a new log.
	 *
	 * @param fecha the fecha
	 * @param detalles the detalles
	 * @param usuario the usuario
	 * @param url the url
	 */
	public Log( Date fecha, String detalles, String usuario, String url) {
		this.fecha = fecha;
		this.detalles = detalles;
		this.usuario = usuario;
		this.url = url;
	}
	
	// getters y setters

	/**
	 * Gets the id log.
	 *
	 * @return the id log
	 */
	public int getIdLog() {
		return idLog;
	}

	/**
	 * Sets the id log.
	 *
	 * @param idLog the new id log
	 */
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the detalles.
	 *
	 * @return the detalles
	 */
	public String getDetalles() {
		return detalles;
	}

	/**
	 * Sets the detalles.
	 *
	 * @param detalles the new detalles
	 */
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	// toString()
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String cadena  = "*************************	LOG	*****************************\n";
		String cadena2 = "***********************************************************\n";
		return 	cadena +
				"Id : " + idLog + " : \n " +			
				"Fecha : " + fecha + " \n " + 
				"Detalles : " + detalles + " \n " +
				"Usuario : " + usuario + " \n " +
				"URL : " + url + " \n " +			
				cadena2
				;	

	}	

}
