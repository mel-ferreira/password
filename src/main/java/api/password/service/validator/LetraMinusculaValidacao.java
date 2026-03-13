package api.password.service.validator;

import api.password.exception.RegraNegocioException;

public class LetraMinusculaValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (!senha.matches(".*[a-z].*")) {
            throw new RegraNegocioException("A senha deve ter pelo menos 1 letra minúscula.");
        }
        return true;
    }
}