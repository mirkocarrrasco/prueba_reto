package com.bcp.tipocambio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bcp.tipocambio.service.impl.SecurityService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
    private BCryptPasswordEncoder codificador;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService).passwordEncoder(codificador);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable().authorizeRequests()
    	.antMatchers("/login").permitAll()
    	.anyRequest().authenticated()
    	.and()
//    	.httpBasic(); //no genera cookis (no guarda sesiones) //el login es como un alert.
//    	.formLogin(); //si genera cookis (sesiones) //Es propio de Spring security para manejar sesiones //el login es una pagina por defecto de spring security.
    	.addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
    	.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
////   	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/login").permitAll()		
//		.antMatchers(HttpMethod.GET, "/monedas").hasRole("USER")
//		.antMatchers(HttpMethod.GET, "/monedas/*").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/monedas/*").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/monedas/*").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
////  	.httpBasic(); //no genera cookis (no guarda sesiones) //el login es como un alert.
////  	.formLogin(); //si genera cookis (sesiones) //Es propio de Spring security para manejar sesiones //el login es una pagina por defecto de spring security.
//		.addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
//		.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
