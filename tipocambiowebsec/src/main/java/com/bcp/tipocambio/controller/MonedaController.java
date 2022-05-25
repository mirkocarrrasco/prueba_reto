package com.bcp.tipocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcp.tipocambio.dto.MonedaDTO;
import com.bcp.tipocambio.service.MonedaService;



@Controller
public class MonedaController {

	@Autowired
	MonedaService monedaService;
	
	@RequestMapping(value="monedaListar", method=RequestMethod.GET)
	public ModelAndView listarMonedas() {
		return new ModelAndView("moneda", "lista", monedaService.listarTodos() );
	}
	
	@RequestMapping(value="monedaGrabar", method=RequestMethod.POST)
	public ModelAndView grabarMoneda(MonedaDTO me) {
		monedaService.insertar(me);
		return new ModelAndView("redirect:monedaListar");
	}
	
	@RequestMapping(value="monedaEliminar", method=RequestMethod.GET)
	public ModelAndView grabarEliminar(@RequestParam("codigo") int idmoneda) {
		monedaService.eliminar(idmoneda);
		return new ModelAndView("redirect:monedaListar");
	}
	
}
