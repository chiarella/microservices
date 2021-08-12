package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.DTO.CompraDTO;
import br.com.microservice.loja.DTO.InfoFornecedorDTO;
import br.com.microservice.loja.DTO.InfoPedidoDTO;
import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.model.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

		System.out.println(info.getEndereco());

		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;

	}

}
