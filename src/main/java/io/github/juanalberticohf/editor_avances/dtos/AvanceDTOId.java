package io.github.juanalberticohf.editor_avances.dtos;

import io.github.juanalberticohf.editor_avances.persistence.entities.Avance;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * DTO que representa un {@link Avance} con su ID y detalles.
 *
 * @author JuanAlberticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
@Setter
@Getter
@ToString
public class AvanceDTOId {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor que inicializa un {@link AvanceDTOId} a partir de un objeto {@link Avance}.
     *
     * @param avance El objeto {@link Avance} del cual se extraen los datos.
     */
    public AvanceDTOId(Avance avance) {
        this.id = avance.getId();
        this.titulo = avance.getTitulo();
        this.descripcion = avance.getDescripcion();
        this.fechaCreacion = avance.getFechaCreacion();
        this.fechaActualizacion = avance.getFechaActualizacion();
    }
}
