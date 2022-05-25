package com.bcp.tipocambio.service;

import java.util.List;

import com.bcp.tipocambio.dao.entity.MonedaEntity;

public interface MonedaService {

	public List<MonedaEntity> listarTodos();

	public MonedaEntity obtenerUno(int codigo);

	public void insertar(MonedaEntity ce);

	public void modificar(MonedaEntity ce);

	public void eliminar(int codigo);

	
}
