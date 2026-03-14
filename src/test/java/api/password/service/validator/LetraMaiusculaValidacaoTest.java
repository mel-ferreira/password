package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LetraMaiusculaValidacaoTest {

    private final LetraMaiusculaValidacao validacao = new LetraMaiusculaValidacao();

    @Test
    void deveAceitarSenhaComLetraMaiuscula() {

        String senha = "ab1@Cdefg";
        boolean resultado = validacao.validador(senha);

        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoNaoTemMaiuscula() {

        String senha = "ab1@cdefg";

        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}