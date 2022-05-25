package com.bcp.tipocambio.service;

import java.util.List;

import com.bcp.tipocambio.dto.MonedaDTO;



public interface MonedaService {

	public List<MonedaDTO> listarTodos();

	public MonedaDTO obtenerUno(int codigo);

	public void insertar(MonedaDTO ce);

	public void modificar(MonedaDTO ce);

	public void eliminar(int codigo);

	
}
