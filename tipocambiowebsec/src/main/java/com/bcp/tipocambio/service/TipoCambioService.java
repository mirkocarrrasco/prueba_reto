package com.bcp.tipocambio.service;

import java.util.List;

import com.bcp.tipocambio.dto.TipoCambioDTO;

public interface TipoCambioService {

	public List<TipoCambioDTO> listarTodos();

	public TipoCambioDTO obtenerUno(int codigo);

	public void insertar(TipoCambioDTO ce);

	public void modificar(TipoCambioDTO ce);

	public void eliminar(int codigo);	
	
}
