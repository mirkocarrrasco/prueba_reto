package com.bcp.tipocambio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tipocambio.dao.entity.MonedaEntity;
import com.bcp.tipocambio.dao.entity.TipoCambioEntity;
import com.bcp.tipocambio.dao.repository.MonedaRepository;
import com.bcp.tipocambio.dao.repository.TipoCambioRepository;
import com.bcp.tipocambio.service.CambioService;

@Service
public class CambioServiceImpl implements CambioService {

	@Autowired
	private MonedaRepository monedaRepository;
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Override
	public Double calcularMonto(int idMonedaOrig, int idMonedaDest, double montoOrig) {
		MonedaEntity monedaEntityOrig = monedaRepository.getById(idMonedaOrig);
		MonedaEntity monedaEntityDest = monedaRepository.getById(idMonedaDest);
		
		TipoCambioEntity tipoCambioEntity = tipoCambioRepository.findByMonedaorigAndMonedadest(monedaEntityOrig, monedaEntityDest);
		Double conversion = tipoCambioEntity.getConversion();
		
		//Realizamos el calculo:
		Double montoDest = conversion * montoOrig;

		return montoDest;
	}
	
	

}
