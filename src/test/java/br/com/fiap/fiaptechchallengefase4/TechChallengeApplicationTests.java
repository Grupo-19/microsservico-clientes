package br.com.fiap.fiaptechchallengefase4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TechChallengeApplicationTests {

    @Test
    void contextLoads() {
        // Esse teste será bem-sucedido se o contexto do Spring for carregado corretamente
        // Se o contexto falhar ao carregar, o teste falhará automaticamente.
        assertTrue(true);// Simples afirmação para garantir que o teste é executado.
    }

}
