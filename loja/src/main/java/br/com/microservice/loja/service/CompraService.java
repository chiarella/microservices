package br.com.microservice.loja.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

	@Autowired // Pega as informações disponiveis do EUREKA
	private DiscoveryClient eurekaClient;

	public void realizaCompra(CompraDTO compra) {
		
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   
		
				
		//RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange = 
				client.exchange(microServicoFornecedor + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		//pegar as instancias do fornecedor
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(fornecedor ->{
			System.out.println("INICIO FOREACH");
			System.out.println("localhost PORTA: " + fornecedor.getPort());
		    System.out.println(dtf.format(LocalDateTime.now()));
		    System.out.println("FIM FOREACH");
		});
		
		//InfoFornecedorDTO -  getBody
		//Mapeaia o Objeto Json
		System.out.println("INICIO" );
		System.out.println("Endereço do fornecedor: " + exchange.getBody().getEndereco());
	    System.out.println(dtf.format(LocalDateTime.now()));
	    System.out.println("FIM");
	    System.out.println("");
	    
		
		

		
		
		
	}

}