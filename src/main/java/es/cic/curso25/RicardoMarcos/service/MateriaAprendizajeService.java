package es.cic.curso25.RicardoMarcos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cic.curso25.RicardoMarcos.exception.MateriaNotFoundException;
import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
import es.cic.curso25.RicardoMarcos.repository.MateriaAprendizajeRepository;

@Service //Dice a spring que aqui tenemos un service
public class MateriaAprendizajeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaAprendizajeService.class);


    //Se usa final porque facilita testing, da inmutabilidad e indica que es obligatorio
    private final MateriaAprendizajeRepository materiaAprendizajeRepository;

    
    //Añadimos este constructor porque facilita test como mock y es recomendado por Spring 
    public MateriaAprendizajeService(MateriaAprendizajeRepository materiaAprendizajeRepository){
        this.materiaAprendizajeRepository= materiaAprendizajeRepository;

    }

    //Listar Materias:
    public List<MateriaAprendizaje> listaMateriasAprendizaje(){
        return materiaAprendizajeRepository.findAll();
    }

    //Bucar usando ID: Antes era necesario usar el tipo Optional porque JpaRepository nos va a devolver un Optional<> pero ahora no se usa porque ya va a devolver directamente materia de aprendizaje o lanza excepcion

    public MateriaAprendizaje buscarPorId(Long id) {
        return materiaAprendizajeRepository.findById(id)
        .orElseThrow(()->new MateriaNotFoundException(id));
    }

    //Crear  

    public MateriaAprendizaje crearMateria(MateriaAprendizaje materiaAprendizaje){
        return materiaAprendizajeRepository.save(materiaAprendizaje);
    }

    //Eliminar por Id

    public void eliminarMateriaAprendizaje(Long id){
        materiaAprendizajeRepository.deleteById(id);
    }


    //Buscar por finalizado (true false)

      public List<MateriaAprendizaje> buscarPorFinalizado(boolean finalizado) {
        return materiaAprendizajeRepository.findByFinalizado(finalizado);
    }

    
     //Buscar por nombre

    public MateriaAprendizaje buscarPorNombre(String nombre) {
        return materiaAprendizajeRepository.findByNombre(nombre);
    }



    //Actualiza la materia
    //Se usa landa lo que nos permite crear una funcion de forma más directa
    public MateriaAprendizaje actualizar(Long id, MateriaAprendizaje nuevaMateria) {
    return materiaAprendizajeRepository.findById(id)
            .map(materia -> {
                materia.setNombre(nuevaMateria.getNombre());
                materia.setFinalizado(nuevaMateria.isFinalizado());
                return materiaAprendizajeRepository.save(materia);
            })
            .orElse(null);
}

}
