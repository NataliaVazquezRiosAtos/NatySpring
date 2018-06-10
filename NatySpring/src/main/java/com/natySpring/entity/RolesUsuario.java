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



// TODO: Auto-generated Javadoc
/**
 * The Class RolesUsuario.
 */
@Entity
@Table(name = "roles_usuario" , uniqueConstraints = @UniqueConstraint(columnNames = {"rol" , "nombreUsu"}))
public class RolesUsuario {
	
	// atributos
	
	/** The id rol. */
	@Id
	@GeneratedValue
	@Column(name="id_rol" , unique=true , nullable=false)
	// unique=true , nullable=false --> son validaciones :
	// unique=true --> que sea unica, que no se pueda repetir
	// nullable=false --> que no pueda tener un  valor null
	private Integer idRol;
	
	/** The usuario. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nombreUsu" , nullable=false)
	private Usuario usuario;
	
	/** The rol. */
	@Column(name="rol" , length=45 , nullable=false)
	private String rol;
	
	// constructores
	
	/**
	 * Instantiates a new roles usuario.
	 */
	public RolesUsuario() {}
	
	/**
	 * Instantiates a new roles usuario.
	 *
	 * @param usuario the usuario
	 * @param rol the rol
	 */
	public RolesUsuario(Usuario usuario, String rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	// getters y setters
	
	/**
	 * Gets the id rol.
	 *
	 * @return the id rol
	 */
	public Integer getIdRol() {
		return idRol;
	}

	/**
	 * Sets the id rol.
	 *
	 * @param idRol the new id rol
	 */
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the nombre usu.
	 *
	 * @param usuario the new nombre usu
	 */
	public void setNombreUsu(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	// to String()
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
