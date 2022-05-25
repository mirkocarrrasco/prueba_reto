package com.bcp.tipocambio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.tipocambio.service.CambioService;
import com.bcp.tipocambio.service.MonedaService;
import com.bcp.tipocambio.service.TipoCambioService;

@Controller
public class CambioController {

	@Autowired
	TipoCambioService tipoCambioService;
	
	@Autowired
	MonedaService monedaService;
	
	@Autowired
	CambioService cambioService;
	
	@RequestMapping(value="cambioPrincipal", method=RequestMethod.GET)
	public ModelAndView listarTipoCambios() {
		ModelAndView mv = new ModelAndView("cambio");
		mv.addObject("listaMonedaOrig", monedaService.listarTodos());
		mv.addObject("listaMonedaDest", monedaService.listarTodos());
		return mv;		
	}
	
	@RequestMapping(value="realizarCalculo", method=RequestMethod.POST)
	public ModelAndView realizarCalculo(HttpServletRequest request) {
		Integer idmonedaOrig = Integer.parseInt(request.getParameter("monedaorig"));
		Integer idmonedaDest = Integer.parseInt(request.getParameter("monedadest"));
		Double montoorig = Double.parseDouble(request.getParameter("montoorig"));
		
		Double montodest = cambioService.calcularMonto(idmonedaOrig, idmonedaDest, montoorig);
				
		ModelAndView mv = new ModelAndView("montonuevo");
		mv.addObject("montodest", montodest);
		return mv;
	}
	
	
}
