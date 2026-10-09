package io.github.juanalberticohf.editor_avances.dtos;

import io.github.juanalberticohf.editor_avances.persistence.entities.Avance;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class AvanceDTOId {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public AvanceDTOId(Avance avance) {
        this.id = avance.getId();
        this.titulo = avance.getTitulo();
        this.descripcion = avance.getDescripcion();
        this.fechaCreacion = avance.getFechaCreacion();
        this.fechaActualizacion = avance.getFechaActualizacion();
    }
}
