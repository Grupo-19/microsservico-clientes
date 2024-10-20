package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.CadastrarClienteInterface;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public class CadastrarCliente {

    private final CadastrarClienteInterface cadastrarClienteInterface;

    public CadastrarCliente(CadastrarClienteInterface cadastrarClienteInterface) {
        this.cadastrarClienteInterface = cadastrarClienteInterface;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return cadastrarClienteInterface.cadastrarCliente(cliente);
    }
}
