package com.bcp.tipocambio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bcp.tipocambio.service.impl.SecurityService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private SecurityService securityService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//csrf():
		//  Es util para tener la plena seguridad que quien este enviando la 
		//  información hacia una ruta del controlador lo este haciendo desde
		//  un formulario que yo haya creado en la aplicación. Lo desactivo.		
		//authorizeRequests():
		//  Que solamente las personas que tienen el rol de admin pueden entrar
		//  a cierta ruta.
		//antMatchers():
		//  Le voy a decir que rutas con el rol.
		//HttpSecurity:
		//  La variable http esta construido sobre el patron Builder es por eso
		//  que yo puedo poner mas de un "antMatchers"
		//anyRequest():
		//  Cualquier petición que requiera una autenticación mendiante un
		//  formulario de login (formlogin()).
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/monedaListar").hasRole("ADMIN")
		.antMatchers("/monedaGrabar").hasRole("ADMIN")
		.antMatchers("/monedaEliminar").hasRole("ADMIN")
		.antMatchers("/tipoCambioListar").hasRole("ADMIN")
		.antMatchers("/tipoCambioGrabar").hasRole("ADMIN")
		.antMatchers("/tipoCambioEliminar").hasRole("ADMIN")		
		.antMatchers("/cambioPrincipal").hasRole("ADMIN")
		.antMatchers("/realizarCalculo").hasRole("ADMIN")
		.antMatchers("/login").permitAll()		
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login").defaultSuccessUrl("/cambioPrincipal")
			.permitAll();
    }
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        return bp;
    }
	
}
