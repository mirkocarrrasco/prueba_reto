package com.bcp.tipocambio.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcp.tipocambio.dao.entity.CredencialJWTEntity;
import com.bcp.tipocambio.dto.MonedaDTO;
import com.bcp.tipocambio.service.LoginJWT;

@Service
public class LoginJWTImpl implements LoginJWT {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;
    
    String tokenGenerado = "";
    String tokenGenerado2 = "";
	
    public LoginJWTImpl() {
    	request = null; 
    }
    
	@Override
	public String loginApiRestConJWT() {
		CredencialJWTEntity credencialJWT = new CredencialJWTEntity();
		credencialJWT.setUsuario("admin");
		credencialJWT.setClave("123");	
		
		headers = new HttpHeaders();
		request = new HttpEntity<String>(headers);
		
		RestTemplate llamada = new RestTemplate();		
		HttpEntity<CredencialJWTEntity> entidad = new HttpEntity<>(credencialJWT, headers);
//		llamada.exchange(backendURL + "/login", HttpMethod.POST, entidad, String.class);
		
		HttpHeaders headers = llamada.exchange(backendURL + "/login", HttpMethod.POST,entidad, CredencialJWTEntity.class).getHeaders();
		tokenGenerado = headers.getFirst("Authorization");
		tokenGenerado2 = tokenGenerado.substring(7);		
		return tokenGenerado2;	
		
	}
	
}
