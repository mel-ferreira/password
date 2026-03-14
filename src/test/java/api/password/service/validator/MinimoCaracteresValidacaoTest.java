package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinimoCaracteresValidacaoTest {

    private final MinimoCaracteresValidacao validacao = new MinimoCaracteresValidacao();

    @Test
    void deveAceitarSenhaCom9OuMaisCaracteres() {

        String senha = "Ab1@cdefg";

        boolean resultado = validacao.validador(senha);
        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoMenorQue9() {

        String senha = "Ab1@def";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}