package br.com.fiap.fiaptechchallengefase4.application.gateway;

import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public interface ObterPorCPFInterface {

    Cliente obterClientePorCPF(String cpf);
}
