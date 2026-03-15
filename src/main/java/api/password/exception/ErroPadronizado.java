package api.password.exception;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class ErroPadronizado {

    private Boolean senhaValidada;
    private Instant tempoErro;
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminhoUrl;

    public ErroPadronizado() {
    }

    public ErroPadronizado( Boolean senhaValidada, Instant tempoErro, Integer status, String erro, String mensagem, String caminhoUrl) {
        this.senhaValidada = senhaValidada;
        this.tempoErro = tempoErro;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.caminhoUrl = caminhoUrl;
    }
}