package com.bcp.tipocambio.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipocambio")
public class TipoCambioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipocambio;	
	
	@OneToOne
    @JoinColumn(name = "idmonedaorig", updatable = false, nullable = false)
    private MonedaEntity monedaorig;
	
	@OneToOne
    @JoinColumn(name = "idmonedadest", updatable = false, nullable = false)
    private MonedaEntity monedadest;
	
	@Column(name = "conversion")
	private double conversion;
	
	
}
