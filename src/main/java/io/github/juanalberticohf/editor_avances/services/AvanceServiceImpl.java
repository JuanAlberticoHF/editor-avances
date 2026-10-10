package io.github.juanalberticohf.editor_avances.services;

import io.github.juanalberticohf.editor_avances.dtos.AvanceDTOId;
import io.github.juanalberticohf.editor_avances.exceptions.AvanceNotFoundException;
import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Implementación del servicio {@link AvanceService}</p>
 *
 * @author JuanAlbeticoHF
 * @version 0.2.0
 * @since 0.0.1
 */
@Service
public class AvanceServiceImpl implements  AvanceService {

    /**
     * Repositorio para acceder a los datos de los avances.
     */
    private final IAvanceRepository avanceRepository;

    public AvanceServiceImpl(IAvanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    @Override
    public List<AvanceDTOId> getAllAvances() {
        return avanceRepository.findAll().stream()
                .map(AvanceDTOId::new)
                .toList();
    }

    @Override
    public AvanceDTOId getAvanceById(Long id) {
        AvanceDTOId avance = avanceRepository.findById(id).map(AvanceDTOId::new).orElse(null);
        if (avance == null) {
            throw new AvanceNotFoundException("Avance not found");
        }
        return avance;
    }
}
