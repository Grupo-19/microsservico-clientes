package br.com.fiap.fiaptechchallengefase4.application.gateway;

import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;

public interface ObterPorIDInterface {

    Cliente obterPorID(Long id);
}
