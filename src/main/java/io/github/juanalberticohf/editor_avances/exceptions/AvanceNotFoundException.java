package io.github.juanalberticohf.editor_avances.exceptions;

/**
 * <p>Excepción personalizada que se lanza cuando no se encuentra un avance específico.</p>
 *
 * @author JuanAlbeticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
public class AvanceNotFoundException extends RuntimeException {
    public AvanceNotFoundException(String message) {
        super(message);
    }
}
