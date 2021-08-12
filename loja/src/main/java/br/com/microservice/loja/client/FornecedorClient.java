package br.com.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservice.loja.DTO.InfoFornecedorDTO;
import br.com.microservice.loja.DTO.InfoPedidoDTO;
import br.com.microservice.loja.DTO.ItemDaCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);

}
