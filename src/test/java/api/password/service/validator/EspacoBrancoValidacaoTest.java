package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EspacoBrancoValidacaoTest {

    private final EspacoBrancoValidacao validacao = new EspacoBrancoValidacao();

    @Test
    void deveAceitarSenhaSemEspaco() {

        String senha = "Ab1@cdefg";
        boolean resultado = validacao.validador(senha);

        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoTemEspaco() {

        String senha = "Ab1@c defg";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}