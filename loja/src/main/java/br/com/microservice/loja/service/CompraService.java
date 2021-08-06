package br.com.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.DTO.CompraDTO;
import br.com.microservice.loja.DTO.InfoFornecedorDTO;

public class CompraService {
	
	private String microServicoFornecedor = "http://localhost:8086/info/";

	public void realizaCompra(CompraDTO compra) {
		
				
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange = 
				client.exchange(microServicoFornecedor + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		
		//InfoFornecedorDTO -  getBody
		//Mapeaia o Objeto Json
		System.out.println(exchange.getBody().getEndereco());
		
	}

}