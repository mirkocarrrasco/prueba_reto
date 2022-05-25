package com.bcp.tipocambio.restcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.tipocambio.dao.entity.TipoCambioEntity;
import com.bcp.tipocambio.service.CambioService;
import com.bcp.tipocambio.service.MonedaService;
import com.bcp.tipocambio.service.TipoCambioService;

@RestController
public class CambioRestController {

	@Autowired
	TipoCambioService tipoCambioService;
	
	@Autowired
	MonedaService monedaService;
	
	@Autowired
	CambioService cambioService;
	
	@GetMapping(path = "/cambio/{monedaorig}/{monedadest}/{montoorig}")
	public Double realizarCalculoGet(
				@PathVariable(value = "monedaorig") int monedaorig,
				@PathVariable(value = "monedadest") int monedadest,	
				@PathVariable(value = "montoorig") double montoorig) {
		
		Double montodest = cambioService.calcularMonto(monedaorig, monedadest, montoorig);
		
		return montodest;
	}
	
}
