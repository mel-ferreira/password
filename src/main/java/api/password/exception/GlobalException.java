package api.password.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ErroPadronizado> regraNegocioException(
            RegraNegocioException e,
            HttpServletRequest request
    )
    {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErroPadronizado err = new ErroPadronizado(
                false,
                Instant.now(),
                status.value(),
                "Regra de negócio",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }
}