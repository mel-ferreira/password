package api.password.service.validator;

import api.password.exception.RegraNegocioException;

public class EspacoBrancoValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        if (senha.contains(" ")) {
            throw new RegraNegocioException("A senha não deve conter espaços em branco.");
        }
        return true;
    }
}