package com.bcp.tipocambio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tipocambio.dao.entity.MonedaEntity;
import com.bcp.tipocambio.dao.repository.MonedaRepository;
import com.bcp.tipocambio.service.MonedaService;


@Service
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	private MonedaRepository monedaRepository;
	
	@Override
	public List<MonedaEntity> listarTodos() {
		return monedaRepository.findAll();
	}

	@Override
	public MonedaEntity obtenerUno(int codigo) {
		return monedaRepository.findById(codigo).get();
	}

	@Override
	public void insertar(MonedaEntity ce) {
		monedaRepository.save(ce);
	}

	@Override
	public void modificar(MonedaEntity ce) {
		monedaRepository.save(ce);
	}

	@Override
	public void eliminar(int codigo) {
		monedaRepository.deleteById(codigo);
	}

}
