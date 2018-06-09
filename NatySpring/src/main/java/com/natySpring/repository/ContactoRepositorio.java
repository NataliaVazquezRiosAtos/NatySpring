package com.natySpring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natySpring.entity.Contacto;

@Repository("repositorioContactos")
public interface ContactoRepositorio extends JpaRepository<Contacto, Serializable> {

}
