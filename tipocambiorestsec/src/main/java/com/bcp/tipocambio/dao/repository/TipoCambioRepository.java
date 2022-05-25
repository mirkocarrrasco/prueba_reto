package com.bcp.tipocambio.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcp.tipocambio.dao.entity.MonedaEntity;
import com.bcp.tipocambio.dao.entity.TipoCambioEntity;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity, Integer> {

	
	public TipoCambioEntity findByMonedaorigAndMonedadest(MonedaEntity monedaEntity1, MonedaEntity monedaEntity2);
		
	
}
