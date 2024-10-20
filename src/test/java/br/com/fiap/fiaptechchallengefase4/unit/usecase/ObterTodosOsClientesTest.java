package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterTodosOsClientesInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.ObterTodosOsClientes;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObterTodosOsClientesTest {

    private ObterTodosOsClientesInterface obterTodosOsClientesInterface;
    private ObterTodosOsClientes obterTodosOsClientes;

    @BeforeEach
    public void setup() {
        obterTodosOsClientesInterface = mock(ObterTodosOsClientesInterface.class);
        obterTodosOsClientes = new ObterTodosOsClientes(obterTodosOsClientesInterface);
    }

    @Test
    @DisplayName("Deve retornar lista de clientes quando existir cliente cadastrado")
    void obterTodosOsClientes() {

        List<Cliente> clientesMock = new ArrayList<>();
        clientesMock.add(new Cliente("Maria Silva", "123.456.789-00", "maria@email.com", "123456"));
        clientesMock.add(new Cliente("joão Silva", "123.456.789-10", "joao@email.com", "123456"));

        when(obterTodosOsClientesInterface.obterTodosOsClientes()).thenReturn(clientesMock);
        List<Cliente> clientesRetornados = obterTodosOsClientes.obterTodosOsClientes();

        assertEquals(2, clientesRetornados.size());
        assertEquals(clientesMock, clientesRetornados);
        verify(obterTodosOsClientesInterface, times(1)).obterTodosOsClientes();
    }

    @Test
    @DisplayName("Deve retornar lista vazias quando não existir cliente cadastrado")
    public void deveRetornarListaVazia() {

        List<Cliente> clientesMock = new ArrayList<>();

        when(obterTodosOsClientesInterface.obterTodosOsClientes()).thenReturn(clientesMock);

        List<Cliente> clientesRetornados = obterTodosOsClientes.obterTodosOsClientes();

        assertEquals(0, clientesRetornados.size());
        verify(obterTodosOsClientesInterface, times(1)).obterTodosOsClientes();
    }
}