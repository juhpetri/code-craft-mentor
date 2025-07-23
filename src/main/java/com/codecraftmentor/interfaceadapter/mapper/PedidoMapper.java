package com.codecraftmentor.interfaceadapter.mapper;

import com.codecraftmentor.domain.model.Pedido;
import com.codecraftmentor.domain.model.Produto;
import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;
import com.codecraftmentor.interfaceadapter.dto.ClienteResumoDTO;
import com.codecraftmentor.interfaceadapter.dto.PedidoDTO;
import com.codecraftmentor.interfaceadapter.dto.ProdutoResumoDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    public Pedido criarPedido(PedidoDTO dto, List<Produto> produtos, double valorTotal) {
        return Pedido.builder()
                .numero(dto.getNumero())
                .pago(dto.getPago())
                .emailCliente(dto.getEmailCliente())
                .produtos(produtos)
                .valorTotal(valorTotal)
                .build();
    }

    public PedidoDTO criarPedidoDTO(Pedido pedido, ClienteDTO clienteDto) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .numero(pedido.getNumero())
                .pago(pedido.getPago())
                .emailCliente(pedido.getEmailCliente())
                .valorTotal(pedido.getValorTotal())
                .cliente(criarResumoClienteDTO(clienteDto))
                .produtos(criarResumoProdutosDTO(pedido.getProdutos()))
                .build();
    }

    private ClienteResumoDTO criarResumoClienteDTO(ClienteDTO clienteDto) {
        return ClienteResumoDTO.builder()
                .id(clienteDto.getId())
                .nome(clienteDto.getNome())
                .email(clienteDto.getEmail())
                .build();
    }

    private List<ProdutoResumoDTO> criarResumoProdutosDTO(List<Produto> produtos) {
        return produtos.stream()
                .map(prod -> ProdutoResumoDTO.builder()
                        .id(prod.getId())
                        .titulo(prod.getTitulo())
                        .valorUnitario(prod.getValorUnitario())
                        .quantidade(prod.getQuantidade())
                        .build())
                .collect(Collectors.toList());
    }
}
