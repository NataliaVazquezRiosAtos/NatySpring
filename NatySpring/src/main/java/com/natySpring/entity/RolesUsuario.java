package com.natySpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "roles_usuario" , uniqueConstraints = @UniqueConstraint(columnNames = {"rol" , "nombreUsu"}))
public class RolesUsuario {
	
	// atributos
	
	@Id
	@GeneratedValue
	@Column(name="id_rol" , unique=true , nullable=false)
	// unique=true , nullable=false --> son validaciones :
	// unique=true --> que sea unica, que no se pueda repetir
	// nullable=false --> que no pueda tener un  valor null
	private Integer idRol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nombreUsu" , nullable=false)
	private Usuario usuario;
	
	@Column(name="rol" , length=45 , nullable=false)
	private String rol;
	
	// constructores
	
	public RolesUsuario() {}
	
	public RolesUsuario(Usuario usuario, String rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	// getters y setters
	
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setNombreUsu(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	// to String()
	
	@Override
	public String toString() {
		
		String cadena = "-----------------------------------------------\n";
		
		return 	cadena +
				"Roles de " + usuario + " : " + "\n" +
				idRol  +" \t " + rol + "\n" +
				cadena
				;
	
	}	

}
