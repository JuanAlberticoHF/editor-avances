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

@RestController
@RequestMapping("/api/avances")
public class AvanceRESTController {
    private final AvanceService avanceService;

    public AvanceRESTController(AvanceService avanceService) {
        this.avanceService = avanceService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AvanceDTOId>> getAllAvances() {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.getAllAvances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvanceDTOId> getAvanceById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.getAvanceById(id));
    }
}
