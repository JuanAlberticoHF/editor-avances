package io.github.juanalberticohf.editor_avances.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>Manejador global de excepciones para la aplicación.</p>
 *
 * @author JuanAlbeticoHF
 * @version 0.1.0
 * @since 0.0.1
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AvanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> handleAvanceNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
