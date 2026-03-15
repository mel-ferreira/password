package api.password.service;

import api.password.exception.RegraNegocioException;
import api.password.service.validator.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorSenhaServiceTest {

    private final ValidadorSenhaService service =
            new ValidadorSenhaService(List.of(
                    new NaoVaziaValidacao(),
                    new MinimoCaracteresValidacao(),
                    new LetraMaiusculaValidacao(),
                    new LetraMinusculaValidacao(),
                    new UmDigitoValidacao(),
                    new EspacoBrancoValidacao(),
                    new CaractereEspecialValidacao(),
                    new RepetirCaractereValidacao()
            ));

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
                RegraNegocioException.class,
                () -> service.validador(senha)
        );
    }
}