package br.com.fiap.fiaptechchallengefase4.infra.gateway;

import br.com.fiap.fiaptechchallengefase4.application.gateway.*;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import br.com.fiap.fiaptechchallengefase4.infra.persistence.ClienteEntity;
import br.com.fiap.fiaptechchallengefase4.infra.persistence.ClienteRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RepositorioDeClienteJpa implements AtualizarClienteInterface,
        CadastrarClienteInterface,
        ExcluirClientePorIDInterface,
        ObterPorCPFInterface,
        ObterPorIDInterface,
        ObterTodosOsClientesInterface{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    public RepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        return mapper.toDomain(clienteRepository.save(entity));
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        return mapper.toDomain(clienteRepository.save(entity));
    }

    @Override
    public void excluirCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Cliente obterClientePorCPF(String cpf) {
        ClienteEntity entity = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        return mapper.toDomain(entity);
    }

    @Override
    public Cliente obterPorID(Long id) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        return mapper.toDomain(entity);
    }

    @Override
    public List<Cliente> obterTodosOsClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
