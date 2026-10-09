package io.github.juanalberticohf.editor_avances.services;

import io.github.juanalberticohf.editor_avances.dtos.AvanceDTOId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvanceService {
    /**
     * Obtiene todos los avances de la base de datos
     * @return Lista de objetos {@link AvanceDTOId} que representan los avances.
     */
    List<AvanceDTOId> getAllAvances();

    /**
     * Obtiene los avances de un usuario específico por su ID
     * @param id El identificador del avance que se desea obtener.
     * @return Lista de objetos {@link AvanceDTOId} que representan los avances del usuario.
     */
    AvanceDTOId getAvanceById(Long id);
}
