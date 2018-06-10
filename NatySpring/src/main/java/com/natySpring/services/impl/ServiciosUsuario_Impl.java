package com.natySpring.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.natySpring.entity.RolesUsuario;
import com.natySpring.entity.Usuario;
import com.natySpring.repository.UsuarioRepositorio;

/*
 * implementamos el servicio que spring tiene para autentificar usuarios
 * 
 * */

@Service("servicioUsuarioImpl")
public class ServiciosUsuario_Impl implements UserDetailsService {
	
	@Autowired
	@Qualifier("repositorioUsuarios")
	private UsuarioRepositorio repoUsu;

	// loadUserByUsername(String username) se va a encargar de llamar a nuestro repositorio
	// va a hacer un buscarPorUsuario() , y obtendremos una entidad usuario
	// esta entidad usuario habra que transformarla y convertirla en un objeto UserDetails
	// para ello hay que hacer dos metodos
	
	// 1.
	// va a devolver un 'user' --> es el tipo de objeto que spring securiry necesita
	private User contruirUsuario(Usuario usuario ,  List<GrantedAuthority> autotentificaciones) {
		
		return new User(usuario.getNombreUsu(), usuario.getContrasenaUsu(), usuario.isActivo(), true, true, true, autotentificaciones);
		
	}
	
	// 2.
	// es el encargado de convertir nuestros roles ,  a una lista de GrantedAuthority	
	// Set<RolesUsuario> rolesDelUsuario --> de la clase Usuario
	// por lo tanto, convierte nuestroSet<RolesUsuario> rolesDelUsuario a una lista de List<GrantedAuthority>
	// ( List<GrantedAuthority> --> que es la lista que spring necesita para saber los roles del usuario autenticado)
	
	private List<GrantedAuthority> construirAutentificaciones(Set<RolesUsuario> rolesDelUsuario){
		
		Set<GrantedAuthority> auten = new HashSet<GrantedAuthority>();
		
		for(RolesUsuario rolesDelUsu : rolesDelUsuario) {
			
			auten.add(new SimpleGrantedAuthority(rolesDelUsu.getRol()));
			
		}
		
		return new ArrayList<GrantedAuthority>(auten);		
	
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usu = repoUsu.findByNombreUsu(username);
		//construirAutentificaciones(usu.);
		List<GrantedAuthority> auto = construirAutentificaciones(usu.getRolesDelUsuario());
		return contruirUsuario(usu , auto);
	}
	

}
