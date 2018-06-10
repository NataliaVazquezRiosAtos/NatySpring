package com.natySpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log {
	
	// atributos
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int idLog;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="detalles")
	private String detalles;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="url")
	private String url;

	// controladores
	
	public Log() {}
	
	public Log( Date fecha, String detalles, String usuario, String url) {
		this.fecha = fecha;
		this.detalles = detalles;
		this.usuario = usuario;
		this.url = url;
	}
	
	// getters y setters

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// toString()
	
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
