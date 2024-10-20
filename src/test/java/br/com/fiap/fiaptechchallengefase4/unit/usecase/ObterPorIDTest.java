package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ObterPorIDInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.ObterPorID;
import br.com.fiap.fiaptechchallengefase4.domain.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObterPorIDTest {
    private ObterPorIDInterface obterPorIDInterface;
    ObterPorID obterPorID;

    @BeforeEach
    void setup() {
        obterPorIDInterface = mock(ObterPorIDInterface.class);
        obterPorID = new ObterPorID(obterPorIDInterface);
    }


        @Test
        @DisplayName("Deve retornar Cliente quando o Id for Valido")
         void deveRetornarClienteQuandoIDValido() {
            Long id = 1L;
            Cliente clienteMock = new Cliente();
            clienteMock.setId(id);
            clienteMock.setNome("Nome  Cliente");

            when(obterPorIDInterface.obterPorID(id)).thenReturn(clienteMock);

            Cliente clienteRetornado = obterPorID.obterClientePorID(id);

            assertEquals(clienteMock, clienteRetornado);
            verify(obterPorIDInterface, times(1)).obterPorID(id);
        }

        @Test
        @DisplayName("Deve retornar Nulo quando o Id for Invalido")
        public void deveRetornarNuloQuandoIDInvalido() {
            Long idInvalido = 999L;

            when(obterPorIDInterface.obterPorID(idInvalido)).thenReturn(null);

            Cliente clienteRetornado = obterPorID.obterClientePorID(idInvalido);

            assertEquals(null, clienteRetornado);
            verify(obterPorIDInterface, times(1)).obterPorID(idInvalido);
        }
}