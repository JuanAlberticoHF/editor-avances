package io.github.juanalberticohf.editor_avances.controllers;

import io.github.juanalberticohf.editor_avances.exceptions.AvanceNotFoundException;
import io.github.juanalberticohf.editor_avances.persistence.entities.Avance;
import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Controlador para manejar las vistas relacionadas con los avances.
 *
 * @author JuanAlberticoHF
 * @version 0.3.0
 * @since 0.0.1
 */
@Controller
@RequestMapping("/avances")
public class AvanceController {

    /**
     * Repositorio para acceder a los datos de los avances.
     */
    private final IAvanceRepository avanceRepository;

    public AvanceController(IAvanceRepository avanceRepository) {
        this.avanceRepository = avanceRepository;
    }

    /**
     * Muestra la lista de avances.
     * @param model El modelo para pasar datos a la vista.
     * @param pageable La información de paginación para la consulta de avances.
     * @return vista "listado" que muestra los avances.
     */
    @GetMapping("/")
    public String listadoAvances(Model model, @PageableDefault(size = 500) Pageable pageable) {
        Page<Avance> avances = avanceRepository.findAll(pageable);
        // Añadir el listado de avances al modelo para que pueda ser accedido en la vista
        model.addAttribute("listadoAvances", avanceRepository.findAll(pageable));
        model.addAttribute("cantidadAvances", avances.getTotalElements());
        return "listado";
    }

    @GetMapping("/crear")
    public String formularioAvance(Model model) {
        // Añadir un objeto Avance vacío al modelo para que pueda ser utilizado en el formulario
        model.addAttribute("avance", new Avance());

        return "formulario_crear";
    }

    @PostMapping("/crear")
    public String crearAvance(Avance avance) {

        avance.setFechaCreacion(java.time.LocalDateTime.now()); // Establecer la fecha de creación al momento actual
        avance.setFechaActualizacion(java.time.LocalDateTime.now()); // Establecer la fecha de actualización al momento actual

        Avance avanceGuardado = avanceRepository.save(avance);

        return "redirect:/avances/" + avanceGuardado.getId();
    }

    /**
     * Muestra la vista de un avance específico basado en su ID.
     * @param model El modelo para pasar datos a la vista.
     * @param id El ID del avance que se desea visualizar.
     * @return vista "vista_avance" que muestra los detalles del avance.
     */
    @GetMapping("/{id}")
    public String vistaAvance(Model model, @PathVariable Long id) {
        // Buscar el avance por su ID, si no se encuentra, lanzar una excepción
        Avance avance = avanceRepository.findById(id).orElseThrow(() ->
                new AvanceNotFoundException("Avance no encontrado con id: " + id));

        model.addAttribute("avance", avance); // Información Avance

        return "vista_avance";
    }

    /**
     * Muestra el formulario para editar un avance específico basado en su ID.
     * @param id El ID del avance que se desea editar.
     * @param model El modelo para pasar datos a la vista.
     * @return vista "formulario_editar" que permite modificar los detalles del avance.
     */
    @GetMapping("/{id}/editar")
    public String formularioAvance(@PathVariable Long id, Model model) {

        Avance avance = avanceRepository.findById(id).orElse(null);

        if (avance == null) {
            return "redirect:/avances/";
        } else {
            model.addAttribute("avance", avance);
            return "formulario_editar";
        }
    }

    @PutMapping("/{id}")
    public String editarAvance(@PathVariable Long id, Avance avanceActualizado) {

        // Igualar que ambos ids existan y sean iguales
        if (!Objects.equals(id, avanceActualizado.getId())) {
            return "redirect:/avances/";
        }

        // Buscar el avance existente por su ID
        Avance avanceExistente = avanceRepository.findById(id).orElse(null);

        if (avanceExistente == null) {
            return "redirect:/avances/";
        }

        // Actualizar los campos del avance existente con los valores del avance recibido
        avanceExistente.setTitulo(avanceActualizado.getTitulo());
        avanceExistente.setDescripcion(avanceActualizado.getDescripcion());
        avanceExistente.setFechaActualizacion(java.time.LocalDateTime.now());

        // Guardar los cambios en la base de datos
        avanceRepository.save(avanceExistente);

        return "redirect:/avances/" + id;
    }

    /**
     * Elimina un avance específico basado en su ID.
     * @param id El ID del avance que se desea eliminar.
     * @return vista "listado" que muestra la lista actualizada de avances después de la eliminación.
     */
    @DeleteMapping("/{id}")
    public String eliminarAvance(@PathVariable Long id) {
        avanceRepository.deleteById(id);
        return "listado";
    }

}
