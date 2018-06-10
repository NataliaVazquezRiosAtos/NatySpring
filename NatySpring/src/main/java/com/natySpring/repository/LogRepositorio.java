package com.natySpring.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natySpring.entity.Log;

@Repository("repositorioLog")
public interface LogRepositorio extends JpaRepository<Log, Serializable> {

}
