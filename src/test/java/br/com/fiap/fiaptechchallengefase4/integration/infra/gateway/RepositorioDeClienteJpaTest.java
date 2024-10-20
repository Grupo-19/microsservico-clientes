package br.com.fiap.fiaptechchallengefase4.integration.infra.gateway;

import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import br.com.fiap.fiaptechchallengefase4.infra.gateway.ClienteMapper;
import br.com.fiap.fiaptechchallengefase4.infra.gateway.RepositorioDeClienteJpa;
import br.com.fiap.fiaptechchallengefase4.infra.persistence.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
class RepositorioDeClienteJpaTest {

    @Autowired
    private ClienteRepository clienteRepository;

    private RepositorioDeClienteJpa repositorioDeClienteJpa;
    private ClienteMapper mapper = new ClienteMapper();

    @BeforeEach
    void setUp() {
        repositorioDeClienteJpa = new RepositorioDeClienteJpa(clienteRepository, mapper);
    }

    @Test
    @DisplayName("Deve cadastrar o Cliente com sucesso")
    void cadastrarCliente() {
        Cliente cliente = new Cliente("Nome", "123.456.789-00", "email@exemplo.com", "123456");
        Cliente cadastrado = repositorioDeClienteJpa.cadastrarCliente(cliente);

        assertNotNull(cadastrado);
        assertNotNull(cadastrado.getId());
        assertEquals("Nome", cadastrado.getNome());
        assertEquals("123.456.789-00", cadastrado.getCpf());
        assertEquals("email@exemplo.com", cadastrado.getEmail());
        assertEquals("123456", cadastrado.getSenha());
    }

    @Test
    @DisplayName("Deve cadastrar o Cliente com sucesso")
    void atualizarCliente() {
        Cliente cliente = new Cliente("Nome", "123.456.789-00", "email@exemplo.com", "123456");
        Cliente cadastrado = repositorioDeClienteJpa.cadastrarCliente(cliente);

        cadastrado.setNome("Nome Atualizado");
        Cliente atualizado = repositorioDeClienteJpa.atualizarCliente(cadastrado);

        assertEquals("Nome Atualizado", atualizado.getNome());
    }


    @Test
    @DisplayName("Deve exluir o Cliente com sucesso")
    void excluirCliente() {
        Cliente cliente = new Cliente("Nome", "123.456.789-00", "email@exemplo.com", "123456");
        Cliente cadastrado = repositorioDeClienteJpa.cadastrarCliente(cliente);

        repositorioDeClienteJpa.excluirCliente(cadastrado.getId());

        assertThrows(NoSuchElementException.class, () -> repositorioDeClienteJpa.obterPorID(cadastrado.getId()));
    }

    @Test
    void obterClientePorCPF() {
    }

    @Test
    void obterPorID() {
    }

    @Test
    void obterTodosOsClientes() {
        Cliente cliente1 = new Cliente("Nome1", "123.456.789-00", "email@exemplo.com", "123456");
        Cliente cliente2 = new Cliente("Nome2", "123.456.789-01", "email@exemplo.com", "123456");

        repositorioDeClienteJpa.cadastrarCliente(cliente1);
        repositorioDeClienteJpa.cadastrarCliente(cliente2);

        List<Cliente> todosOsClientes = repositorioDeClienteJpa.obterTodosOsClientes();

        assertEquals(2, todosOsClientes.size());
    }
}