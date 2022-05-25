package com.bcp.tipocambio.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tipocambio.dto.MonedaDTO;
import com.bcp.tipocambio.service.LoginJWT;
import com.bcp.tipocambio.service.MonedaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class MonedaServiceImpl implements MonedaService {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;
    
    @Autowired
    LoginJWT loginJWT;

    public MonedaServiceImpl() {
//    	request = null;    	
    	
//    	headers = new HttpHeaders();
//    	headers.add("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2dlbGlvIiwiZXhwIjoxNjUzMjQyNDgxfQ._8SHlZleVlLkWxp2LYVrN0AimhwwdgJnxKKH-x10n4EPs2gr0N8G35kwjaQOQkOdu66HtUmpuvFg5reQesMrnQ");
//    	request = new HttpEntity<String>(headers);     	
    }
	
	@Override
	public List<MonedaDTO> listarTodos() {
		headers = new HttpHeaders();
    	headers.add("Authorization", loginJWT.loginApiRestConJWT());
    	request = new HttpEntity<String>(headers);
    	
    	
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<MonedaDTO[]> resultado = plantilla.exchange(backendURL + "/monedas", HttpMethod.GET, request, MonedaDTO[].class);
        MonedaDTO[] lista = resultado.getBody();
        List<MonedaDTO> retorno = Arrays.asList(lista);
        return retorno;
	}

	@Override
	public MonedaDTO obtenerUno(int codigo) {
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<MonedaDTO> resultado = plantilla.exchange(backendURL + "/monedas/" + codigo, HttpMethod.GET, request, MonedaDTO.class);
        MonedaDTO moneda = resultado.getBody();
        return moneda;
	}

	@Override
	public void insertar(MonedaDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<MonedaDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/monedas", HttpMethod.POST, entidad, MonedaDTO.class);
	}

	@Override
	public void modificar(MonedaDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<MonedaDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/monedas", HttpMethod.PUT, entidad, MonedaDTO.class);
	}

	@Override
	public void eliminar(int codigo) {
		RestTemplate llamada = new RestTemplate();
        llamada.exchange(backendURL + "/monedas/" + codigo, HttpMethod.DELETE, request, MonedaDTO.class);
	}

	

}
