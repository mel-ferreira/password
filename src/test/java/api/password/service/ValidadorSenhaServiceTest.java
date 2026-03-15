package api.password.service;

import api.password.exception.RegraNegocioException;
import api.password.service.validator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validador de Senha Service")
class ValidadorSenhaServiceTest {

    private ValidadorSenhaService service;

    @BeforeEach
    void setUp() {
       service = new ValidadorSenhaService(
                List.of(
                new NaoVaziaValidacao(),
                new MinimoCaracteresValidacao(),
                new LetraMaiusculaValidacao(),
                new LetraMinusculaValidacao(),
                new UmDigitoValidacao(),
                new EspacoBrancoValidacao(),
                new CaractereEspecialValidacao(),
                new RepetirCaractereValidacao()
        ));
    }
    @Nested
    @DisplayName("Quando a senha é válida")
    class SenhaValida
    {
        @Test
        @DisplayName("Deve retornar true")
        void deveRetornarTrue()
        {
            String senha = "AbTp9!fok";

            boolean resultado = service.validador(senha);
            assertTrue(resultado);
        }
    }
    @Nested
    @DisplayName("Quando a senha é inválida")
    class SenhaInvalida
    {
        @ParameterizedTest(name = "Senha inválida: {0}")
        @ValueSource(strings = {
                "",
                "abcdefghi",
                "ABCDEFGHI",
                "Abcdefghi",
                "Abcdefg1",
                "AbTp9!foo"
        })
        @DisplayName("Deve lançar exceção para senhas inválidas")
        void deveLancarExcecao(String senha) {

            assertThrows(
                    RegraNegocioException.class,
                    () -> service.validador(senha)
            );
        }
    }
}