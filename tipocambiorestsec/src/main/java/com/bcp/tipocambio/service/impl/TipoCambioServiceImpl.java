package com.bcp.tipocambio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tipocambio.dao.entity.TipoCambioEntity;
import com.bcp.tipocambio.dao.repository.TipoCambioRepository;
import com.bcp.tipocambio.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Override
	public List<TipoCambioEntity> listarTodos() {
		return tipoCambioRepository.findAll();
	}

	@Override
	public TipoCambioEntity obtenerUno(int codigo) {
		return tipoCambioRepository.findById(codigo).get();
	}

	@Override
	public void insertar(TipoCambioEntity ce) {
		tipoCambioRepository.save(ce);
	}

	@Override
	public void modificar(TipoCambioEntity ce) {
		tipoCambioRepository.save(ce);
		
	}

	@Override
	public void eliminar(int codigo) {
		tipoCambioRepository.deleteById(codigo);
	}

	

}
