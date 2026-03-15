package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class EspacoBrancoValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (senha.contains(" ")) {
            throw new RegraNegocioException("A senha não deve conter espaços em branco.");
        }
        return true;
    }
}