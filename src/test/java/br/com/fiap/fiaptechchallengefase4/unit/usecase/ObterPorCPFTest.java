package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterPorCPFInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.ObterPorCPF;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObterPorCPFTest {

    private ObterPorCPFInterface obterPorCPFInterface;
    private ObterPorCPF obterPorCPF;

    @BeforeEach
    public void setup() {
        obterPorCPFInterface = mock(ObterPorCPFInterface.class);
        obterPorCPF = new ObterPorCPF(obterPorCPFInterface);
    }

    @Test
    @DisplayName("Deve retornar Cliente quando CPF for Valido")
    void obterClientePorCPF() {
        String cpf = "123.456.789-10";
        Cliente clienteMock = new Cliente();
        clienteMock.setCpf(cpf);
        clienteMock.setNome("Nome Cliente");

        when(obterPorCPFInterface.obterClientePorCPF(cpf)).thenReturn(clienteMock);

        Cliente clienteRetornado = obterPorCPF.obterClientePorCPF(cpf);
        assertEquals(clienteMock, clienteRetornado);
        verify(obterPorCPFInterface, times(1)).obterClientePorCPF(cpf);
    }

    @Test
    @DisplayName("Deve retornar nulo quando CPF não encontrado")
    public void deveRetornarNulo() {
        String cpfInvalido = "000.000.000-00";

        when(obterPorCPFInterface.obterClientePorCPF(cpfInvalido)).thenReturn(null);

        Cliente clienteRetornado = obterPorCPF.obterClientePorCPF(cpfInvalido);


        assertEquals(null, clienteRetornado);
        verify(obterPorCPFInterface, times(1)).obterClientePorCPF(cpfInvalido);
    }
}