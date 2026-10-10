package io.github.juanalberticohf.editor_avances.controllers;

import io.github.juanalberticohf.editor_avances.dtos.AvanceDTOId;
import io.github.juanalberticohf.editor_avances.services.AvanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para manejar las solicitudes relacionadas con los avances.
 *
 * @author JuanAlberticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/avances")
public class AvanceRESTController {

    /**
     * Servicio para manejar la lógica de negocio relacionada con los avances.
     */
    private final AvanceService avanceService;

    public AvanceRESTController(AvanceService avanceService) {
        this.avanceService = avanceService;
    }

    /**
     * Obtiene todos los avances.
     *
     * @return Una lista de objetos {@link AvanceDTOId} que representan los avances.
     */
    @GetMapping("/")
    public ResponseEntity<List<AvanceDTOId>> getAllAvances() {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.getAllAvances());
    }

    /**
     * Obtiene un avance específico por su ID.
     * @param id El identificador del avance que se desea obtener.
     * @return Un objeto {@link AvanceDTOId} que representa el avance solicitado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvanceDTOId> getAvanceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.getAvanceById(id));
    }
}
