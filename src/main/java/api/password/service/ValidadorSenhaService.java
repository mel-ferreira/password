package api.password.service;
import api.password.service.validator.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidadorSenhaService {

    private final List<SenhaValidacao> validacoes;

    public ValidadorSenhaService() {

        this.validacoes = List.of(
                new NaoVaziaValidacao(),
                new MinimoCaracteresValidacao(),
                new LetraMaiusculaValidacao(),
                new LetraMinusculaValidacao(),
                new UmDigitoValidacao(),
                new EspacoBrancoValidacao(),
                new CaractereEspecialValidacao(),
                new RepetirCaractereValidacao()
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