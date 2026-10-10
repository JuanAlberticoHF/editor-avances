package io.github.juanalberticohf.editor_avances.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Configuración de OpenAPI para la documentación de la API REST</p>
 *
 * @author JuanAlbeticoHF
 * @version 0.5.0
 * @since 0.0.1
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Editor Avances API",
                version = "0.5.0",
                description = "Documentación de la API de Editor Avances"
        )
)
public class OpenAPIConfig {}