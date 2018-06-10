package com.natySpring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/*
 * para la configuracion que no se puede añadir al application.yml , tenemos que crear clases
 * que nos configuren nuestra aplicacion en el paquete configuration
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled=true) : anotacion que nos permite escribir anotaciones
 * para controlar el acceso a los metodos, segun la seguridad
 * */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
	
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }  

	// cargamos el servicio servicioUsuarioImpl
	@Autowired
	@Qualifier("servicioUsuarioImpl")
	private UserDetailsService serviciosUsuario;

	// sobreescribimos el metodo configureGlobal()
	// nos sirve para añadir el 'UserDetailsService' que hemos creado
	// BCryptPasswordEncoder() es el encargado de cifrar la contraseña para meterla
	// en base de datos
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auto) throws Exception {
		
		auto.userDetailsService(serviciosUsuario).passwordEncoder(new BCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // indica los que estan autorizados sin necesidad de un login
			.antMatchers("/css/*" ,"/imgs/*") // indicamos que se pueden cargar todos los recursos estaticos que tengamos
			.permitAll() // permitir a todos
			.anyRequest() //el resto de requests
			.authenticated() // autentificacion necesria
			
		.and() // y
		
		.formLogin() // formulario de login
			.loginPage("/login") // pagina de login
			.loginProcessingUrl("/comprobarlogin") // url que procesa el login
			// checkLogin en form
			.usernameParameter("usuarioForm") // parametro nombre del usuario en el formulario
			.passwordParameter("contrasenaForm") // parametro nombre del contraseña en el formulario
			.defaultSuccessUrl("/logincorrecto") // url a la que se redirige si el login es correcto
			.permitAll() // permitir a todos
			
		.and() // y
		
		.logout() //logout
			.logoutUrl("/logout") // url de logout
			.logoutSuccessUrl("/login?logout")  //  url a la que se redirige : ira a /login con parametro ?logout
			.permitAll(); // permitir a todos		
	}


}
