package api.password.service;


import api.password.service.validator.MinimoCaracteresValidacao;
import api.password.service.validator.SenhaValidacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidadorSenhaService {

    private final List<SenhaValidacao> validacoes;

    public ValidadorSenhaService() {

        this.validacoes = List.of(
                new MinimoCaracteresValidacao()
        );
    }

    public boolean validador(String senha) {

        for (SenhaValidacao validacao : validacoes) {
            if (!validacao.validador(senha)) {
                return false;
            }
        }
        return true;

    }
}