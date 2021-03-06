package br.com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;

	public InfoFornecedor getInfoPorEstado(String estado) {

		return infoRepository.findByEstado(estado);
	}

	//Verificar
	public void save(Object object) {
		// TODO Auto-generated method stub
		
	}

}
