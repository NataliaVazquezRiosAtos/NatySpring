package com.natySpring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {	
	
	// atributos
	
	@Id
	@Column(name="nombre_usuario", unique=true , nullable=false , length=45)
	private String nombreUsu;
	
	@Column(name="contrasena" , nullable=false , length=60)
	// length=60 --> 60 porque es el tamaño que necesitamos para cifrar en la tabla la contrasena
	// ejemplo: si la contrasena fuese '1234' , esa cadena se transforma en la tabla en una cadena de 60 caracteres siempre
	private String contrasenaUsu;
	
	@Column(name="activo" , nullable=false )
	private boolean activo;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="usuario")
	private Set<RolesUsuario> rolesDelUsuario = new HashSet<RolesUsuario>();	
	
	// constructores
	
	public Usuario() {}
	
	public Usuario(String nombreUsu, String contrasenaUsu, boolean activo) {
		super();
		this.nombreUsu = nombreUsu;
		this.contrasenaUsu = contrasenaUsu;
		this.activo = activo;
	}

	public Usuario(String nombreUsu, String contrasenaUsu, boolean activo, Set<RolesUsuario> rolesDelUsuario) {
		super();
		this.nombreUsu = nombreUsu;
		this.contrasenaUsu = contrasenaUsu;
		this.activo = activo;
		this.rolesDelUsuario = rolesDelUsuario;
	}

	// getters y setters
	
	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getContrasenaUsu() {
		return contrasenaUsu;
	}

	public void setContrasenaUsu(String contrasenaUsu) {
		this.contrasenaUsu = contrasenaUsu;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<RolesUsuario> getRolesDelUsuario() {
		return rolesDelUsuario;
	}

	public void setRolesDelUsuario(Set<RolesUsuario> rolesDelUsuario) {
		this.rolesDelUsuario = rolesDelUsuario;
	}

	// toString()
	@Override
	public String toString() {
		
		String cadena = "******************************************************\n";
		
		return 	cadena +
				"Ususario : " + nombreUsu + " : \n " +			
				"Contrasena : " + contrasenaUsu + " \n " + 
				"Activo : " + activo + " \n " +
				rolesDelUsuario +
				cadena
				;		
		
	}

}
