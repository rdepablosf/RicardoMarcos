package es.cic.curso25.RicardoMarcos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
import es.cic.curso25.RicardoMarcos.service.MateriaAprendizajeService;

@RestController
@RequestMapping("/materias")
public class MateriaAprendizajeController {

    // Se usa final porque facilita testing, da inmutabilidad e indica que es
    // obligatorio
    private final MateriaAprendizajeService materiaAprendizajeService;

    public MateriaAprendizajeController(MateriaAprendizajeService materiaAprendizajeService) {
        this.materiaAprendizajeService = materiaAprendizajeService;
    }

    // Lista todo
    @GetMapping
    public List<MateriaAprendizaje> listadoCompleto() {
        return materiaAprendizajeService.listaMateriasAprendizaje();
    }

    // Busca por id
    @GetMapping("/{id}")
    public Optional<MateriaAprendizaje> buscarPorId(@PathVariable Long id) {
        return materiaAprendizajeService.buscarPorId(id);
    }

    // Crea nueva
    @PostMapping
    public MateriaAprendizaje crear(@RequestBody MateriaAprendizaje materiaAprendizaje) {
        return materiaAprendizajeService.crearMateria(materiaAprendizaje);
    }

    // Borra por Id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        materiaAprendizajeService.eliminarMateriaAprendizaje(id);
    }

    // Busca por finalizado
    @GetMapping("/finalizado/{estado}")
    public List<MateriaAprendizaje> buscarPorFinalizado(@PathVariable boolean estado) {
        return materiaAprendizajeService.buscarPorFinalizado(estado);
    }

    // Busca por nombre
    @GetMapping("/nombre/{nombre}")
    public MateriaAprendizaje buscarPorNombre(@PathVariable String nombre) {
        return materiaAprendizajeService.buscarPorNombre(nombre);
    }

    // Actualizar

    // @PutMapping("/{id}")
    // public ResponseEntity<MateriaAprendizaje> actualizar(
    //         @PathVariable Long id,
    //         @RequestBody MateriaAprendizaje nuevaMateria) {

    //     MateriaAprendizaje materiaActualizada = materiaAprendizajeService.actualizar(id, nuevaMateria);

    //     if (materiaActualizada != null) {
    //         return ResponseEntity.ok(materiaActualizada);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

}
