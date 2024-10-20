package br.com.fiap.fiaptechchallengefase4.infra.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name  = "nome")
    private String nome;

    @Column(name  = "cpf")
    private String cpf;

    @Column(name  = "email")
    private String email;

    @Column(name  = "senha")
    private String senha;

    public ClienteEntity(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
}
