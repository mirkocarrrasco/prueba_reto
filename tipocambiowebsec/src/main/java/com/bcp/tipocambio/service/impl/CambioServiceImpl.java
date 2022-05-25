package com.bcp.tipocambio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcp.tipocambio.dto.MonedaDTO;
import com.bcp.tipocambio.service.CambioService;
import com.bcp.tipocambio.service.LoginJWT;

@Service
public class CambioServiceImpl implements CambioService {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;
    
    @Autowired
    LoginJWT loginJWT;
	
    public CambioServiceImpl() {
//    	request = null;
    	
//    	headers = new HttpHeaders();
//    	headers.add("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2dlbGlvIiwiZXhwIjoxNjUzMjQyNDgxfQ._8SHlZleVlLkWxp2LYVrN0AimhwwdgJnxKKH-x10n4EPs2gr0N8G35kwjaQOQkOdu66HtUmpuvFg5reQesMrnQ");
//    	request = new HttpEntity<String>(headers); 
    }
    
    
	@Override
	public Double calcularMonto(int idMonedaOrig, int idMonedaDest, double montoOrig) {
		headers = new HttpHeaders();
    	headers.add("Authorization", loginJWT.loginApiRestConJWT());
    	request = new HttpEntity<String>(headers);
    	
		RestTemplate plantilla = new RestTemplate();
        //http://localhost:8013/cambio/1/2/1000
		ResponseEntity<Double> resultado = plantilla.exchange(backendURL + "/cambio/" + idMonedaOrig + "/" + idMonedaDest + "/" + montoOrig
				, HttpMethod.GET, request, Double.class);
        Double montonuevo = resultado.getBody();
        return montonuevo;
	}

}
