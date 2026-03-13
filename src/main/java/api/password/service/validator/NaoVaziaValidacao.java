package api.password.service.validator;

import api.password.exception.RegraNegocioException;

public class NaoVaziaValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (senha == null || senha.isEmpty()) {
            throw new RegraNegocioException("A senha não pode ser vazia");
        }
        return true;
    }
}