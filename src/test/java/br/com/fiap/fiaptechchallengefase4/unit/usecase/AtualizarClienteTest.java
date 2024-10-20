package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.AtualizarClienteInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.AtualizarCliente;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtualizarClienteTest {



    @Test
    @DisplayName("Deve atualizar cliente com sucesso")
    void atualizarCliente() {
        Cliente clienteOriginal = new Cliente("nome Cliente", "123.456.789-10", "email@cliente.com", "123456" );
        Cliente clienteAtualizado = new Cliente("nome Cliente Atualizado", "123.456.789-10", "email@cliente.com", "123456" );

        AtualizarClienteInterface atualizarClienteInterface = mock(AtualizarClienteInterface.class);
        when(atualizarClienteInterface.atualizarCliente(clienteAtualizado)).thenReturn(clienteAtualizado);

        AtualizarCliente atualizarClienteUseCase = new AtualizarCliente(atualizarClienteInterface);
        Cliente resultado = atualizarClienteUseCase.atualizarCliente(clienteAtualizado);

        assertEquals("nome Cliente Atualizado", resultado.getNome());

        verify(atualizarClienteInterface, times(1)).atualizarCliente(clienteAtualizado);


    }
}