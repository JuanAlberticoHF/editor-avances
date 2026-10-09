package io.github.juanalberticohf.editor_avances.controllers;

import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioController {

    private final IAvanceRepository avanceRepository;

    public InicioController(IAvanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    @GetMapping("/")
    public String vistaInicio(Model model) {
        model.addAttribute("numeroEndpoints", (short) 2);
        model.addAttribute("cantidadAvances", avanceRepository.count());
        return "index";
    }
}
