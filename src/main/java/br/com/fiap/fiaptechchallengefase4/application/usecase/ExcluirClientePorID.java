package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ExcluirClientePorIDInterface;

public class ExcluirClientePorID {

    private final ExcluirClientePorIDInterface excluirClientePorIDInterface;

    public ExcluirClientePorID(ExcluirClientePorIDInterface excluirClientePorIDInterface) {
        this.excluirClientePorIDInterface = excluirClientePorIDInterface;
    }

    public void excluirClientePorID(Long id) {
        excluirClientePorIDInterface.excluirCliente(id);
    }
}
