package api.password.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorSenhaServiceTest {

    private final ValidadorSenhaService service = new ValidadorSenhaService();

    @Test
    void deveValidarSenhaCompleta() {

        String senha = "Ab1@cdefg";

        boolean resultado = service.validador(senha);
        assertTrue(resultado);
    }

    @Test
    void deveFalharQuandoSenhaInvalida() {

        String senha = "abcdefghi";

        assertThrows(
                Exception.class,
                () -> service.validador(senha)
        );
    }
}