package br.com.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.loja.DTO.CompraDTO;
import br.com.microservice.loja.model.Compra;
import br.com.microservice.loja.service.CompraService;
import br.com.microservice.loja.service.CompraServiceTeste;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@Autowired CompraServiceTeste teste;
	
	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return compraService.realizaCompra(compra);
		
	}
	
	@PostMapping("/teste")
	public void verificaInstancias(@RequestBody CompraDTO compra) {
		teste.realizaCompra2(compra);
	}
	
}