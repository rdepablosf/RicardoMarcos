package es.cic.curso25.RicardoMarcos.controler;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.http.MediaType;

import es.cic.curso25.RicardoMarcos.controller.MateriaAprendizajeController;
import es.cic.curso25.RicardoMarcos.exception.MateriaNotFoundException;
import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
import es.cic.curso25.RicardoMarcos.service.MateriaAprendizajeService;

@WebMvcTest(MateriaAprendizajeController.class) // Le indicamos el controlador a testear
public class MateriaAprendizajeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simulará peticiones HTTP

    @MockitoBean // Simula comportamiento de un Bean
    private MateriaAprendizajeService materiaAprendizajeService;

    @Test
    void buscarPorId_devuelveMateriaSiExiste() throws Exception {
        // Arrange
        MateriaAprendizaje materia = new MateriaAprendizaje();
        materia.setId(1L);
        materia.setNombre("JAVA");
        materia.setFinalizado(false);

        when(materiaAprendizajeService.buscarPorId(1L)).thenReturn(materia);

        // Act & Assert
        mockMvc.perform(get("/materias/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Esperamos 200 OK
                .andExpect(jsonPath("$.nombre").value("JAVA")); // Validamos el campo nombre que aparecerá en el JSON
    }

  

}
