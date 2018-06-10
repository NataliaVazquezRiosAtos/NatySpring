package com.natySpring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natySpring.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario , Serializable> {

	public abstract Usuario buscarPorUsuario(String nombreUsuario);
	
}
