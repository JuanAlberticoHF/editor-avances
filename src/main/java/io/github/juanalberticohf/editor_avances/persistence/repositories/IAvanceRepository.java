package io.github.juanalberticohf.editor_avances.persistence.repositories;


import io.github.juanalberticohf.editor_avances.persistence.entities.Avance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Repositorio para la entidad Avance</p>
 *
 * @author JuanAlbeticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
public interface IAvanceRepository extends JpaRepository<Avance, Long> {
}
