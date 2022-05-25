package com.bcp.tipocambio.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bcp.tipocambio.dao.entity.AuditoriaEntity;



@RepositoryRestResource(path = "auditoria")
public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity, Integer> {

	List<AuditoriaEntity> findByOperacionContains(@Param("operacion") String opera);

}
