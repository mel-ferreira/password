package api.password.service.validator;

import api.password.exception.RegraNegocioException;

public class LetraMaiusculaValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (!senha.matches(".*[A-Z].*")) {
            throw new RegraNegocioException("A senha deve ter pelo menos 1 letra maiúscula.");
        }
        return true;
    }
}