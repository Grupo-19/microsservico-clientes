package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterTodosOsClientesInterface;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

import java.util.List;

public class ObterTodosOsClientes {

    private final ObterTodosOsClientesInterface obterTodosOsClientesInterface;

    public ObterTodosOsClientes(ObterTodosOsClientesInterface obterTodosOsClientesInterface) {
        this.obterTodosOsClientesInterface = obterTodosOsClientesInterface;
    }

    public List<Cliente> obterTodosOsClientes() {
        return obterTodosOsClientesInterface.obterTodosOsClientes();
    }
}
