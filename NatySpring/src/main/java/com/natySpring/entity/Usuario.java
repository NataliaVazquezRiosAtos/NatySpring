package com.natySpring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name="usuarios")
public class Usuario {	
	
	// atributos
	
	/** The nombre usu. */
	@Id
	@Column(name="nombre_usuario", unique=true , nullable=false , length=45)
	private String nombreUsu;
	
	/** The contrasena usu. */
	@Column(name="contrasena" , nullable=false , length=60)
	// length=60 --> 60 porque es el tamaño que necesitamos para cifrar en la tabla la contrasena
	// ejemplo: si la contrasena fuese '1234' , esa cadena se transforma en la tabla en una cadena de 60 caracteres siempre
	private String contrasenaUsu;
	
	/** The activo. */
	@Column(name="activo" , nullable=false )
	private boolean activo;
	
	/** The roles del usuario. */
	@OneToMany(fetch = FetchType.EAGER , mappedBy="usuario")
	private Set<RolesUsuario> rolesDelUsuario = new HashSet<RolesUsuario>();	
	
	// constructores
	
	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {}
	
	/**
	 * Instantiates a new usuario.
	 *
	 * @param nombreUsu the nombre usu
	 * @param contrasenaUsu the contrasena usu
	 * @param activo the activo
	 */
	public Usuario(String nombreUsu, String contrasenaUsu, boolean activo) {
		super();
		this.nombreUsu = nombreUsu;
		this.contrasenaUsu = contrasenaUsu;
		this.activo = activo;
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param nombreUsu the nombre usu
	 * @param contrasenaUsu the contrasena usu
	 * @param activo the activo
	 * @param rolesDelUsuario the roles del usuario
	 */
	public Usuario(String nombreUsu, String contrasenaUsu, boolean activo, Set<RolesUsuario> rolesDelUsuario) {
		super();
		this.nombreUsu = nombreUsu;
		this.contrasenaUsu = contrasenaUsu;
		this.activo = activo;
		this.rolesDelUsuario = rolesDelUsuario;
	}

	// getters y setters
	
	/**
	 * Gets the nombre usu.
	 *
	 * @return the nombre usu
	 */
	public String getNombreUsu() {
		return nombreUsu;
	}

	/**
	 * Sets the nombre usu.
	 *
	 * @param nombreUsu the new nombre usu
	 */
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	/**
	 * Gets the contrasena usu.
	 *
	 * @return the contrasena usu
	 */
	public String getContrasenaUsu() {
		return contrasenaUsu;
	}

	/**
	 * Sets the contrasena usu.
	 *
	 * @param contrasenaUsu the new contrasena usu
	 */
	public void setContrasenaUsu(String contrasenaUsu) {
		this.contrasenaUsu = contrasenaUsu;
	}

	/**
	 * Checks if is activo.
	 *
	 * @return true, if is activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 *
	 * @param activo the new activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the roles del usuario.
	 *
	 * @return the roles del usuario
	 */
	public Set<RolesUsuario> getRolesDelUsuario() {
		return rolesDelUsuario;
	}

	/**
	 * Sets the roles del usuario.
	 *
	 * @param rolesDelUsuario the new roles del usuario
	 */
	public void setRolesDelUsuario(Set<RolesUsuario> rolesDelUsuario) {
		this.rolesDelUsuario = rolesDelUsuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
