package com.bcp.tipocambio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bcp.tipocambio.aspect.UsuarioAspecto;
import com.bcp.tipocambio.dao.entity.UsuarioEntity;
import com.bcp.tipocambio.dao.repository.UsuarioRepositorio;


@Service
public class SecurityService implements UserDetailsService {

	@Autowired
    private UsuarioRepositorio usuarioRepositorio;
	
	@Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        UsuarioEntity ue = usuarioRepositorio.findById(nombre).get();
        UsuarioAspecto.nombreuser = nombre;        
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
//      UserDetails udet = new User(ue.getUsuario(), "{noop}" + ue.getClave(), roles); //Sin clave cifrada
        UserDetails udet = new User(ue.getUsuario(), ue.getClave(), roles); //Con clave cifrada
        return udet;
    }
	
}
