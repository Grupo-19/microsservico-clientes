package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.CadastrarClienteInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.CadastrarCliente;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CadastrarClienteTest {

    @InjectMocks
    private CadastrarCliente cadastrarCliente;
    @Mock
    private CadastrarClienteInterface cadastrarClienteInterface;



    @Test
    @DisplayName("Deve cadastrar um cliente com sucesso")
    void cadastrarCliente() {
        Cliente cliente = new Cliente();
        when(cadastrarClienteInterface.cadastrarCliente(Mockito.<Cliente>any())).thenReturn(cliente);

        Cliente clienteCadastrado = cadastrarCliente.cadastrarCliente(new Cliente());

        verify(cadastrarClienteInterface).cadastrarCliente(isA(Cliente.class));
        assertSame(cliente, clienteCadastrado);
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar cadastrar um cliente inválido")
    void cadastrarClienteInvalido() {
        when(cadastrarClienteInterface.cadastrarCliente(any(Cliente.class)))
                .thenThrow(new IllegalArgumentException("Dados Invalidos"));

        assertThrows(IllegalArgumentException.class, () ->{
            cadastrarCliente.cadastrarCliente(new Cliente());
        });

        verify(cadastrarClienteInterface).cadastrarCliente(isA(Cliente.class));
    }

    private final CadastrarCliente cadastrarClienteNulo = new CadastrarCliente(null);
    @Test
    @DisplayName("Deve lançar exceção quando o CPF for nulo")
    void deveLancarExcecaoQuandoCpfForNulo() {
        Cliente cliente = new Cliente();
        cliente.setNome("Nome");
        cliente.setEmail("email@exemplo.com");
        cliente.setCpf(null);

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o CPF for vazio")
    void deveLancarExcecaoQuandoCpfForVazio() {
        Cliente cliente = new Cliente();
        cliente.setNome("Nome");
        cliente.setEmail("email@exemplo.com");
        cliente.setCpf("");

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o nome for nulo")
    void deveLancarExcecaoQuandoNomeForNulo() {
        Cliente cliente = new Cliente();
        cliente.setCpf("123.456.789-00");
        cliente.setEmail("email@example.com");
        cliente.setNome(null);

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o nome for vazio")
    void deveLancarExcecaoQuandoNomeForVazio() {
        Cliente cliente = new Cliente();
        cliente.setCpf("123.456.789-00");
        cliente.setEmail("email@example.com");
        cliente.setNome("");

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o email for nulo")
    void deveLancarExcecaoQuandoEmailForNulo() {
        Cliente cliente = new Cliente();
        cliente.setCpf("123.456.789-00");
        cliente.setNome("Nome");
        cliente.setEmail(null);

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o email for vazio")
    void deveLancarExcecaoQuandoEmailForVazio() {
        Cliente cliente = new Cliente();
        cliente.setCpf("123.456.789-00");
        cliente.setNome("Nome");
        cliente.setEmail("");

        assertThrows(NullPointerException.class, () -> cadastrarClienteNulo.cadastrarCliente(cliente),
                "Campo Obrigatório está nulo ou vazio");
    }



    @Test
    @DisplayName("Deve lançar exceção quando o CPF estiver em formato inválido")
    void deveLancarExcecaoQuandoCpfFormatoInvalido() {
        String cpfInvalido = "12345678900";
        assertThrows(IllegalArgumentException.class, () ->
                        new Cliente("Nome", cpfInvalido, "email@example.com", "senha"),
                "CPF no formato inválido"
        );
    }

    @Test
    @DisplayName("Deve lançar exceção quando o Email estiver em formato inválido")
    void deveLancarExcecaoQuandoEmailFormatoInvalido() {
        String emailInvalido = "email@com";
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("Nome", "123.456.789-00", emailInvalido, "senha");
        });
    }

}