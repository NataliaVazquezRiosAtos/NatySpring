package com.natySpring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natySpring.entity.Usuario;

@Repository("repositorioUsuarios")
public interface UsuarioRepositorio extends JpaRepository<Usuario , Serializable> {

	// obligatoriamente  en  findBy : findByNombreDelAtributoDeLaEntidad
	public abstract Usuario findByNombreUsu(String nombreUsuario);
	
}
