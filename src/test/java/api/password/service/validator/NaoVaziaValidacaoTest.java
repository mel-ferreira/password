package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NaoVaziaValidacaoTest {

    private final NaoVaziaValidacao validacao = new NaoVaziaValidacao();

    @Test
    void deveAceitarSenhaNaoVazia() {

        String senha = "Ab1@cdefg";

        boolean resultado = validacao.validador(senha);
        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoSenhaVazia() {

        String senha = "";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}