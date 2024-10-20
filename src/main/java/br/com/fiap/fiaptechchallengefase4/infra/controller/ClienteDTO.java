package br.com.fiap.fiaptechchallengefase4.infra.controller;

public record ClienteDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String senha
) {
}
