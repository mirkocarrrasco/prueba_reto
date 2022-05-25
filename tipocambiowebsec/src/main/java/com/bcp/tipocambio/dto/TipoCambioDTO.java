package com.bcp.tipocambio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambioDTO {

	int idtipocambio;	
	MonedaDTO monedaorig;
	MonedaDTO monedadest;
	double conversion;
}
