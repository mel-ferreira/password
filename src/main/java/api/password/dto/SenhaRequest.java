package api.password.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaRequest {

    @Schema(description = "Senha a ser validada", example = "AbTp9!fok")
    public String senha;
}