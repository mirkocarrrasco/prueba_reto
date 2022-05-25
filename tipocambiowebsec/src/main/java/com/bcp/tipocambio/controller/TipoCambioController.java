package com.bcp.tipocambio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.tipocambio.dto.MonedaDTO;
import com.bcp.tipocambio.dto.TipoCambioDTO;
import com.bcp.tipocambio.service.MonedaService;
import com.bcp.tipocambio.service.TipoCambioService;



@Controller
public class TipoCambioController {

	@Autowired
	TipoCambioService tipoCambioService;
	
	@Autowired
	MonedaService monedaService;	
	
	@RequestMapping(value="tipoCambioListar", method=RequestMethod.GET)
	public ModelAndView listarTipoCambios() {
//		return new ModelAndView("tipoCambio", "lista", tipoCambioService.listarTodos() );
		ModelAndView mv = new ModelAndView("tipoCambio", "lista", tipoCambioService.listarTodos() );
		mv.addObject("listaMonedaOrig", monedaService.listarTodos());
		mv.addObject("listaMonedaDest", monedaService.listarTodos());
		return mv;		
	}
	
//	@RequestMapping(value="tipoCambioGrabar", method=RequestMethod.POST)
//	public ModelAndView grabarTipoCambio(TipoCambioDTO me) {
////		tipoCambioService.insertar(me);
//		return new ModelAndView("redirect:tipoCambioListar");
//	}
	
	@RequestMapping(value="tipoCambioGrabar", method=RequestMethod.POST)
	public ModelAndView grabarTipoCambio(HttpServletRequest request) {		
		String monedaorig = request.getParameter("monedaorig");
		String monedadest = request.getParameter("monedadest");
		String conversion = request.getParameter("conversion");
		MonedaDTO monedaDTOOrig = monedaService.obtenerUno(Integer.parseInt(monedaorig));
		MonedaDTO monedaDTODest = monedaService.obtenerUno(Integer.parseInt(monedadest));
		Double conversionDouble = Double.parseDouble(conversion);		
		TipoCambioDTO tc = new TipoCambioDTO();
		tc.setMonedaorig(monedaDTOOrig);
		tc.setMonedadest(monedaDTODest);
		tc.setConversion(conversionDouble);	
		tipoCambioService.insertar(tc);
		return new ModelAndView("redirect:tipoCambioListar");
	}	
	
	@RequestMapping(value="tipoCambioEliminar", method=RequestMethod.GET)
	public ModelAndView grabarEliminar(@RequestParam("codigo") int idtipocambio) {
		tipoCambioService.eliminar(idtipocambio);
		return new ModelAndView("redirect:tipoCambioListar");
	}
	
}
