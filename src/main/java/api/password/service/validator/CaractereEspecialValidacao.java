package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(6)
@Component
public class CaractereEspecialValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (!senha.matches(".*[!@#$%^&*()\\-+].*")) {
            throw new RegraNegocioException("A senha deve ter pelo menos 1 caractere especial, exemplo: !@#$%^&*()-+.");
        }
        return true;
    }
}