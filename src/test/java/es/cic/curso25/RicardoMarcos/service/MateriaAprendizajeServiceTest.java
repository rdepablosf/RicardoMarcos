package es.cic.curso25.RicardoMarcos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
import es.cic.curso25.RicardoMarcos.repository.MateriaAprendizajeRepository;

public class MateriaAprendizajeServiceTest {

    @Mock //Crea objetos simulados que permiten probar la logica de la clase 
    private MateriaAprendizajeRepository materiaAprendizajeRepository;

    @InjectMocks
    private MateriaAprendizajeService materiaAprendizajeService;

    @BeforeEach //Inicializa las anotaciones de Mockito en cada test 
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarIdExiste(){
         MateriaAprendizaje materia = new MateriaAprendizaje();

        //Creamos el objeto simulado
         materia.setId(1L); //L indica que es un long
        materia.setNombre("JAVA");
        when(materiaAprendizajeRepository.findById(1L)).thenReturn(Optional.of(materia));

        //Creamos el que vamos a buscar
        MateriaAprendizaje busqueda= materiaAprendizajeService.buscarPorId(1L);

        assertNotNull(busqueda);
        assertEquals("JAVA", busqueda.getNombre());
        verify(materiaAprendizajeRepository).findById(1L); // Verifica que se llamó al repositorio
         
    }


}
