package br.com.fiap.fiaptechchallengefase4.integration.controller;

import br.com.fiap.fiaptechchallengefase4.application.usecase.*;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static com.jayway.jsonpath.JsonPath.read;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private CadastrarCliente cadastrarCliente;

    @Autowired
    private AtualizarCliente atualizarCliente;

    @Autowired
    private ExcluirClientePorID excluirClientePorID;

    @Autowired
    private ObterPorCPF obterPorCPF;

    @Autowired
    private ObterPorID obterPorID;

    @Autowired
    private ObterTodosOsClientes obterTodosOsClientes;

    @Test
    @DisplayName("Deve cadastrar um cliente com dados válidos")
    public void deveCadastrarCliente() throws Exception {
        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.cpf").value("123.456.789-01"));
    }

    @Test
    @DisplayName("Deve atualizar um cliente com dados válidos")
    public void testAtualizarCliente() throws Exception {
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"));

        mockMvc.perform(put("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Nome Atualizado\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome Atualizado"));
    }

    @Test
    @DisplayName("Deve excluir  um cliente com id válido")
    public void testExcluirClientePorID() throws Exception {
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"));

        mockMvc.perform(delete("/cliente/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve Listar os clientes quando existir clientes cadastrados")
    public void testListarClientes() throws Exception {
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"));

        mockMvc.perform(get("/cliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Nome"));
    }

    @Test
    @DisplayName("Deve buscar um cliente utilizando cpf")
    public void testObterClientePorCPF() throws Exception {
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"));

        mockMvc.perform(get("/cliente/cpf/{cpf}", "123.456.789-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"));
    }

    @Test
    @DisplayName("Deve buscar um cliente utilizando ID")
    public void testObterClientePorID() throws Exception {
        String response = mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Nome\",\"cpf\":\"123.456.789-01\",\"email\":\"email@example.com\",\"senha\":\"senha\"}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Integer clienteIdInteger = read(response, "$.id");
        Long clienteId = clienteIdInteger.longValue();

        mockMvc.perform(get("/cliente/id/{id}", clienteId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Nome"));
    }
}