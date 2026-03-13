package api.password.service.validator;

import api.password.exception.RegraNegocioException;

public class MinimoCaracteresValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (senha == null || senha.length() < 9) {
            throw new RegraNegocioException("A senha deve ter no mínimo 9 caracteres");
        }
        return true;
    }
}
