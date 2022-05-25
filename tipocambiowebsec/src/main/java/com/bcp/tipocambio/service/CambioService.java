package com.bcp.tipocambio.service;

public interface CambioService {

	public Double calcularMonto(int idMonedaOrig, int idMonedaDest, double montoOrig);
}
