package br.com.microservice.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	
	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		return infoService.getInfoPorEstado(estado);
				
	}
	
	@RequestMapping("/cadastrar")
	public void save(@RequestBody Object object) {
		infoService.save(object);
	}
	

}