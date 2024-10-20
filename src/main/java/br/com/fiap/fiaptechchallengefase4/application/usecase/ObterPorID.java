package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterPorIDInterface;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public class ObterPorID {

    private final ObterPorIDInterface obterPorIDInterface;

    public ObterPorID(ObterPorIDInterface obterPorIDInterface) {
        this.obterPorIDInterface = obterPorIDInterface;
    }

    public Cliente obterClientePorID(Long id) {
        return obterPorIDInterface.obterPorID(id);
    }
}
