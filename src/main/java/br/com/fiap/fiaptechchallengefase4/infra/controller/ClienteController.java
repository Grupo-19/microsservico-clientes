package br.com.fiap.fiaptechchallengefase4.infra.controller;

import br.com.fiap.fiaptechchallengefase4.application.usecase.*;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final AtualizarCliente atualizarCliente;
    private final CadastrarCliente cadastrarCliente;
    private final ExcluirClientePorID excluirClientePorID;
    private final ObterPorCPF obterPorCPF;
    private final ObterPorID obterPorID;
    private final ObterTodosOsClientes obterTodosOsClientes;

    public ClienteController(AtualizarCliente atualizarCliente,
                             CadastrarCliente cadastrarCliente,
                             ExcluirClientePorID excluirClientePorID,
                             ObterPorCPF obterPorCPF,
                             ObterPorID obterPorID,
                             ObterTodosOsClientes obterTodosOsClientes) {
        this.atualizarCliente = atualizarCliente;
        this.cadastrarCliente = cadastrarCliente;
        this.excluirClientePorID = excluirClientePorID;
        this.obterPorCPF = obterPorCPF;
        this.obterPorID = obterPorID;
        this.obterTodosOsClientes = obterTodosOsClientes;
    }


    @PutMapping
    public ClienteDTO atualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = atualizarCliente.atualizarCliente(new Cliente(
                clienteDTO.id(),
                clienteDTO.nome(),
                clienteDTO.cpf(),
                clienteDTO.email(),
                clienteDTO.senha()));

        return new ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = cadastrarCliente.cadastrarCliente(new Cliente(
                clienteDTO.nome(),
                clienteDTO.cpf(),
                clienteDTO.email(),
                clienteDTO.senha()));

        return new ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @DeleteMapping("/{id}")
    public void excluirClientePorID(@PathVariable Long id) {
        excluirClientePorID.excluirClientePorID(id);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        obterTodosOsClientes.obterTodosOsClientes()
                .forEach(v -> clientes.add(
                        new ClienteDTO(
                                v.getId(),
                                v.getNome(),
                                v.getCpf(),
                                v.getEmail(),
                                v.getSenha()
                        )
                ));
        return clientes;
    }

    @GetMapping("/cpf/{cpf}")
    public ClienteDTO obterClientePorCPF(@PathVariable("cpf") String cpf) {
        Cliente cliente = obterPorCPF.obterClientePorCPF(cpf);
        return new ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @GetMapping("/id/{id}")
    public ClienteDTO obterClientePorID(@PathVariable("id") Long id) {
        Cliente cliente = obterPorID.obterClientePorID(id);
        return new ClienteDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSenha());
    }
}
