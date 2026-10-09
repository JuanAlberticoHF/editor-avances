package io.github.juanalberticohf.editor_avances.controllers;

import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avances")
public class AvanceController {

    private final IAvanceRepository avanceRepository;

    public AvanceController(IAvanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    @GetMapping("/")
    public String listadoAvances(Model model) {
        // Añadir el listado de avances al modelo para que pueda ser accedido en la vista
        model.addAttribute("listadoAvances", avanceRepository.findAll());
        return "listado";
    }

    @GetMapping("/crear")
    public String formularioAvance() {
        return "formulario";
    }

    @GetMapping("/{id}")
    public String vistaAvance(@PathVariable Long id) {
        return "vista_avance";
    }

    @GetMapping("/{id}/editar")
    public String formularioAvance(@PathVariable Long id) {
        return "formulario";
    }

    @DeleteMapping("/{id}")
    public String eliminarAvance(@PathVariable Long id) {
        avanceRepository.deleteById(id);
        return "listado";
    }

}
