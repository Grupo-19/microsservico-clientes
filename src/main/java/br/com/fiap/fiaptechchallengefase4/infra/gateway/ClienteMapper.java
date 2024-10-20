package br.com.fiap.fiaptechchallengefase4.infra.gateway;

import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import br.com.fiap.fiaptechchallengefase4.infra.persistence.ClienteEntity;

public class ClienteMapper {

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha()
        );
    }

    public Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getSenha());
    }
}
