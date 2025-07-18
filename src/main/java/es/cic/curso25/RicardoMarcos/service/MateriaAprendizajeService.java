package es.cic.curso25.RicardoMarcos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
import es.cic.curso25.RicardoMarcos.repository.MateriaAprendizajeRepository;

@Service //Dice a spring que aqui tenemos un service
public class MateriaAprendizajeService {
    private MateriaAprendizajeRepository materiaAprendizajeRepository;

    
    //Añadimos este constructor porque facilita test como mock y es recomendado por Spring 
    public MateriaAprendizajeService(MateriaAprendizajeRepository materiaAprendizajeRepository){
        this.materiaAprendizajeRepository= materiaAprendizajeRepository;

    }

    //Listar Materias:
    public List<MateriaAprendizaje> listaMateriasAprendizaje(){
        return materiaAprendizajeRepository.findAll();
    }

    //Bucar usando ID: es necesario usar el tipo Optional porque JpaRepository nos va a devolver un Optional<>

    public Optional<MateriaAprendizaje> buscarPorId(Long id) {
        return materiaAprendizajeRepository.findById(id);
    }

    //Crear o actualizar 

    public MateriaAprendizaje crearMateria(MateriaAprendizaje materiaAprendizaje){
        return materiaAprendizajeRepository.save(materiaAprendizaje);
    }

    //Eliminar por Id

    public void eliminarMateriaAprendizaje(Long id){
        materiaAprendizajeRepository.deleteById(id);
    }

    //Buscar por nombre

    public MateriaAprendizaje buscarPorNombre(String nombre) {
        return materiaAprendizajeRepository.findByNombre(nombre);
    }

    //Buscar por finalizado (true false)

      public List<MateriaAprendizaje> buscarPorFinalizado(boolean finalizado) {
        return materiaAprendizajeRepository.findByFinalizado(finalizado);
    }

}
