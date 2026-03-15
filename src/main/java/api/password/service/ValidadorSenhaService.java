package api.password.service;
import api.password.service.validator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidadorSenhaService {

    private static final Logger log = LoggerFactory.getLogger(ValidadorSenhaService.class);

    private final List<SenhaValidacao> validacoes;

    public ValidadorSenhaService(List<SenhaValidacao> validacoes) {
        this.validacoes = validacoes;
    }

    public boolean validador(String senha) {

        log.debug("Rodando {} validações", validacoes.size());

        for (SenhaValidacao validacao : validacoes) {
            if (!validacao.validador(senha)) {
                return false;
            }
        }
        return true;
    }
}