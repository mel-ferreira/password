package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LetraMinusculaValidacaoTest {

    private final LetraMinusculaValidacao validacao = new LetraMinusculaValidacao();

    @Test
    void deveAceitarSenhaComLetraMinuscula() {

        String senha = "AB1@cdefg";
        boolean resultado = validacao.validador(senha);

        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoNaoTemMinuscula() {

        String senha = "AB1@CDEFG";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}