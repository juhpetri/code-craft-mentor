package com.codecraftmentor.application.service;

import com.codecraftmentor.domain.model.Pedido;
import com.codecraftmentor.domain.model.Produto;
import com.codecraftmentor.domain.usecase.ClienteUseCase;
import com.codecraftmentor.domain.usecase.PedidoUseCase;
import com.codecraftmentor.domain.usecase.ProdutoUseCase;
import com.codecraftmentor.infrastructure.repository.PedidoRepository;
import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;
import com.codecraftmentor.interfaceadapter.dto.PedidoDTO;
import com.codecraftmentor.interfaceadapter.mapper.PedidoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements PedidoUseCase {
    private final PedidoRepository pedidoRepository;
    private final ClienteUseCase clienteUseCase;
    private final ProdutoUseCase produtoUseCase;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository, ClienteUseCase clienteUseCase, ProdutoUseCase produtoUseCase, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteUseCase = clienteUseCase;
        this.produtoUseCase = produtoUseCase;
        this.pedidoMapper = pedidoMapper;
    }


    @Override
    public PedidoDTO cadastrarPedido(PedidoDTO dto) {
        ClienteDTO clienteDto = buscarClientePorEmail(dto.getEmailCliente());
        List<Produto> produtos = buscarProdutos(dto);
        double valorTotal = calcularValorTotal(produtos);

        Pedido pedido = pedidoMapper.criarPedido(dto, produtos, valorTotal);
        Pedido salvo = pedidoRepository.save(pedido);

        return pedidoMapper.criarPedidoDTO(salvo, clienteDto);
    }

    @Override
    public List<PedidoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(pedido -> {
                    ClienteDTO clienteDto = buscarClientePorEmail(pedido.getEmailCliente());
                    return pedidoMapper.criarPedidoDTO(pedido, clienteDto);
                })
                .collect(Collectors.toList());
    }

    private ClienteDTO buscarClientePorEmail(String email) {
        ClienteDTO cliente = clienteUseCase.buscarClientePorEmail(email);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado para o e-mail: " + email);
        }
        return cliente;
    }

    private List<Produto> buscarProdutos(PedidoDTO dto) {
        return dto.getProdutos().stream()
                .map(prodDto -> produtoUseCase.buscarProdutoPorId(prodDto.getId()))
                .collect(Collectors.toList());
    }

    private double calcularValorTotal(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(prod -> prod.getValorUnitario() * prod.getQuantidade())
                .sum();
    }
}
