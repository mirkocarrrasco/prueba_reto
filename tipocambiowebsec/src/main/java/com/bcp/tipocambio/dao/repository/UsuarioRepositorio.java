package com.bcp.tipocambio.dao.repository;

import com.bcp.tipocambio.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, String> {

}
