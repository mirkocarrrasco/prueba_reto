package com.bcp.tipocambio.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

	@Size(min=3, max=10)
    @Id
    private String usuario;
    
    @NotNull
    @Column(nullable = false)
    private String clave;
    
    @Column(name = "nomcompleto")
    private String nombreCompleto;
    
}
