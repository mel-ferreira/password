package api.password.controller;

import api.password.dto.SenhaRequest;
import api.password.dto.SenhaResponse;
import api.password.service.ValidadorSenhaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validacao")
public class SenhaController {

    @Autowired
    ValidadorSenhaService validadorSenhaService;

    @Operation(summary = "Valida uma senha conforme regras de segurança")
    @PostMapping
    public ResponseEntity<SenhaResponse> validarSenha(@RequestBody @Valid SenhaRequest senhaRequest)
    {
        boolean valido = validadorSenhaService.validador(senhaRequest.senha);

        SenhaResponse senhaResponse = new SenhaResponse();
        senhaResponse.senhaValidada = valido;

        return ResponseEntity.ok().body(senhaResponse);
    }
}