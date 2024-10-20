package br.com.fiap.fiaptechchallengefase4.config;

import br.com.fiap.fiaptechchallengefase4.application.gateway.*;
import br.com.fiap.fiaptechchallengefase4.application.usecase.*;
import br.com.fiap.fiaptechchallengefase4.infra.gateway.ClienteMapper;
import br.com.fiap.fiaptechchallengefase4.infra.gateway.RepositorioDeClienteJpa;
import br.com.fiap.fiaptechchallengefase4.infra.persistence.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    AtualizarCliente atualizarCliente(AtualizarClienteInterface atualizarCliente) {
        return new AtualizarCliente(atualizarCliente);
    }

    @Bean
    CadastrarCliente cadastrarCliente(CadastrarClienteInterface cadastrarCliente) {
        return new CadastrarCliente(cadastrarCliente);
    }

    @Bean
    ExcluirClientePorID excluirClientePorID(ExcluirClientePorIDInterface clientePorID) {
        return new ExcluirClientePorID(clientePorID);
    }

    @Bean
    ObterPorCPF obterPorCPF(ObterPorCPFInterface obterPorCPF) {
        return new ObterPorCPF(obterPorCPF);
    }

    @Bean
    ObterPorID obterPorID(ObterPorIDInterface obterPorID) {
        return new ObterPorID(obterPorID);
    }

    @Bean
    ObterTodosOsClientes obterTodosOsClientes(ObterTodosOsClientesInterface obterTodosOsClientes) {
        return new ObterTodosOsClientes(obterTodosOsClientes);
    }

    @Bean
    RepositorioDeClienteJpa criaRepositorioDeClienteJpa(ClienteRepository clienteRepository,
                                                        ClienteMapper mapper) {
        return new RepositorioDeClienteJpa(clienteRepository, mapper);
    }

    @Bean
    ClienteMapper criaClienteMapper() {
        return new ClienteMapper();
    }
}
