package com.bcp.tipocambio.service;

import java.util.List;

import com.bcp.tipocambio.dao.entity.TipoCambioEntity;

public interface TipoCambioService {

	public List<TipoCambioEntity> listarTodos();

	public TipoCambioEntity obtenerUno(int codigo);

	public void insertar(TipoCambioEntity ce);

	public void modificar(TipoCambioEntity ce);

	public void eliminar(int codigo);	
	
}
