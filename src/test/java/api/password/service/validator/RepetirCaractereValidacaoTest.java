package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepetirCaractereValidacaoTest {

    private final RepetirCaractereValidacao validacao = new RepetirCaractereValidacao();

    @Test
    void deveAceitarSenhaSemCaracteresRepetidos() {

        String senha = "Ab1@cdefg";

        boolean resultado = validacao.validador(senha);
        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoTemCaracterRepetido() {

        String senha = "Ab1@cdefA";

        RegraNegocioException exception =
                assertThrows(RegraNegocioException.class,
                        () -> validacao.validador(senha));

        assertTrue(exception.getMessage().contains("repetidos"));
    }
}