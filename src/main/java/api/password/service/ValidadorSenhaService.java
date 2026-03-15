package api.password.service;
import api.password.service.validator.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidadorSenhaService {

    private final List<SenhaValidacao> validacoes;

    public ValidadorSenhaService(List<SenhaValidacao> validacoes) {
        this.validacoes = validacoes;
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