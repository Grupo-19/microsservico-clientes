package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.AtualizarClienteInterface;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public class AtualizarCliente {

    private final AtualizarClienteInterface atualizarClienteInterface;

    public AtualizarCliente(AtualizarClienteInterface atualizarClienteInterface) {
        this.atualizarClienteInterface = atualizarClienteInterface;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return atualizarClienteInterface.atualizarCliente(cliente);
    }
}
