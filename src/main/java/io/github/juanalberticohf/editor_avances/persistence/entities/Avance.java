package io.github.juanalberticohf.editor_avances.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>Entidad que representa un avance en la aplicación.</p>
 *
 * @author JuanAlbeticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
@Entity
@Table(name = "Avance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
