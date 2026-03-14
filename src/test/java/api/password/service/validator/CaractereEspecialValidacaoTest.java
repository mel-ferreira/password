package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaractereEspecialValidacaoTest {

    CaractereEspecialValidacao validacao = new CaractereEspecialValidacao();

    @Test
    void deveAceitarSenhaComCaractereEspecial() {

        String senha = "Ab1@cdefg";
        boolean resultado = validacao.validador(senha);

        assertTrue(resultado);
    }

    @Test
    void deveLancarErroQuandoNaoTemCaractereEspecial() {

        String senha = "Ab1cdefgh";
        assertThrows(
                RegraNegocioException.class,
                () -> validacao.validador(senha)
        );
    }
}