package api.password.service.validator;

import api.password.exception.RegraNegocioException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Order(7)
@Component
public class RepetirCaractereValidacao implements SenhaValidacao {

    @Override
    public boolean validador(String senha) {

        Set<Character> caracteres = new HashSet<>();

        for (char c : senha.toCharArray()) {

            if (!caracteres.add(c)) {
                throw new RegraNegocioException("A senha não pode conter caracteres repetidos");
            }
        }
        return true;
    }
}