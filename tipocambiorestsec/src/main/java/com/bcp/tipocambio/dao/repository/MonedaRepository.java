package com.bcp.tipocambio.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcp.tipocambio.dao.entity.MonedaEntity;


@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity, Integer> {

}
