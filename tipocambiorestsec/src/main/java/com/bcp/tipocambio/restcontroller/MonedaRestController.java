package com.bcp.tipocambio.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.tipocambio.dao.entity.MonedaEntity;

import com.bcp.tipocambio.service.MonedaService;

@RestController
public class MonedaRestController {

	@Autowired
	private MonedaService monedaService;
	
	@GetMapping(path = "/monedas")
	public List<MonedaEntity> listarTodos() {
		return monedaService.listarTodos();
	}
	
	@GetMapping(path = "/monedas/{id}")
	public MonedaEntity obtenerUno(@PathVariable(value = "id") int codigo) {
		return monedaService.obtenerUno(codigo);
	}
	
//	@PostMapping("/monedas")
//	public void insertar(@RequestBody MonedaEntity ce) {
//		monedaService.insertar(ce);
//	}
	
	@PostMapping("/monedas")
	public ResponseEntity<MonedaEntity> insertarResponseEntity(@RequestBody MonedaEntity ce) {
		monedaService.insertar(ce);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/monedas/{id}")
	public void modificar(@RequestBody MonedaEntity ce, @PathVariable(value = "id") int codigo) {
		ce.setIdmoneda(codigo);
		monedaService.modificar(ce);
	}
	
	@DeleteMapping("/monedas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable(value = "id") int codigo) {
		monedaService.eliminar(codigo);
	}
}
