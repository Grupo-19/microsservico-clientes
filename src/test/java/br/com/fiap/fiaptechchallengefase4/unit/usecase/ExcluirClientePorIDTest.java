package br.com.fiap.fiaptechchallengefase4.unit.usecase;

import br.com.fiap.fiaptechchallengefase4.application.gateway.ExcluirClientePorIDInterface;
import br.com.fiap.fiaptechchallengefase4.application.usecase.ExcluirClientePorID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExcluirClientePorIDTest {


    @Test
    @DisplayName("Deve chamar excluir cliente por ID, com sucesso")
    void deveExcluirPorID(){

        ExcluirClientePorIDInterface excluirClientePorIDInterface = mock(ExcluirClientePorIDInterface.class);
        ExcluirClientePorID excluirClientePorID = new ExcluirClientePorID(excluirClientePorIDInterface);
        Long idCliente = 1L;

        excluirClientePorID.excluirClientePorID(idCliente);

        verify(excluirClientePorIDInterface, times(1)).excluirCliente(idCliente);

    }
}