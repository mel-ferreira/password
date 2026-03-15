package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class NaoVaziaValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (senha == null || senha.isEmpty()) {
            throw new RegraNegocioException("A senha não pode ser vazia");
        }
        return true;
    }
}