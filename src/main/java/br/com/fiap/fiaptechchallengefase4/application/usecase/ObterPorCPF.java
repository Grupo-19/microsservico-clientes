package br.com.fiap.fiaptechchallengefase4.application.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterPorCPFInterface;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public class ObterPorCPF {

    private final ObterPorCPFInterface obterPorCPFInterface;

    public ObterPorCPF(ObterPorCPFInterface obterPorCPFInterface) {
        this.obterPorCPFInterface = obterPorCPFInterface;
    }

    public Cliente obterClientePorCPF(String cpf) {
        return obterPorCPFInterface.obterClientePorCPF(cpf);
    }
}
