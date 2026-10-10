package io.github.juanalberticohf.editor_avances.controllers;

import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar la vista de inicio de la aplicación.
 *
 * @author JuanAlberticoHF
 * @version 1.0.0
 * @since 0.0.1
 */
@Controller
@RequestMapping("/")
public class InicioController {

    /**
     * Repositorio para acceder a los datos de los avances.
     */
    private final IAvanceRepository avanceRepository;

    public InicioController(IAvanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    /**
     * Muestra la vista de inicio de la aplicación.
     * @param model El modelo para pasar datos a la vista.
     * @return El nombre de la vista a renderizar.
     */
    @GetMapping("/")
    public String vistaInicio(Model model) {
        model.addAttribute("numeroEndpoints", (short) 2);
        model.addAttribute("cantidadAvances", avanceRepository.count());
        return "index";
    }
}
