package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UmDigitoValidacaoTest {

    private final UmDigitoValidacao validacao = new UmDigitoValidacao();

    @Test
    void deveAceitarSenhaComDigito() {

        String senha = "Ab1@cdefg";

        boolean resultado = validacao.validador(senha);
        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoNaoTemDigito() {

        String senha = "Ab@cdefgh";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}