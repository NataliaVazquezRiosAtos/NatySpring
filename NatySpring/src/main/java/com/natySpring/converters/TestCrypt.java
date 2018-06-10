package com.natySpring.converters;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * para insertar "a pelo" el usuario de pruebas en bd, nos hace falta cifrar la contraseña
 * 
 * */

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String contrasena ="micontraseña";
		System.out.println("La contaseña '" + contrasena + "' cifrada es: " + pe.encode(contrasena));

	}

}
