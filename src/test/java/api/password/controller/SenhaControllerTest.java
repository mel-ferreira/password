package api.password.controller;

import api.password.dto.SenhaRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SenhaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve retornar true quando a senha for válida")
    void deveRetornarTrueQuandoSenhaForValida() throws Exception {

        SenhaRequest request = new SenhaRequest();
        request.setSenha("AbTp9!fok");

        ResultActions result = mockMvc.perform(
                post("/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        );

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.senhaValidada").value(true));
    }
    @Test
    @DisplayName("Deve retornar false quando a senha for inválida")
    void deveRetornarFalseQuandoSenhaForInvalida() throws Exception
    {
        SenhaRequest request = new SenhaRequest();
        request.setSenha("123");

        ResultActions result = mockMvc.perform(
                post("/validacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        );
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.erro").value("Regra de negócio"));
    }
}