package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.DTO.CompraDTO;
import br.com.microservice.loja.DTO.InfoFornecedorDTO;

@Service
public class CompraService {
	
	private String microServicoFornecedor = "http://fornecedor/info/";
	
	@Autowired
	private RestTemplate client;

	public void realizaCompra(CompraDTO compra) {
		
				
		//RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange = 
				client.exchange(microServicoFornecedor + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		
		//InfoFornecedorDTO -  getBody
		//Mapeaia o Objeto Json
		System.out.println("Endereço do fornecedor: " + exchange.getBody().getEndereco());
		
	}

}