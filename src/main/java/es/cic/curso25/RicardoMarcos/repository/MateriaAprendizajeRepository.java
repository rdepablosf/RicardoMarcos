package es.cic.curso25.RicardoMarcos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso25.RicardoMarcos.model.MateriaAprendizaje;
//JpaRepository es una interfaz que ya incluye todas las operaciones CRUD básicas lo implementamos en nuestro proyecto para poder tener acceso a ellas.
public interface MateriaAprendizajeRepository extends JpaRepository<MateriaAprendizaje, Long> {

    List <MateriaAprendizaje> findByFinalizado(boolean finalizado); //Sentencia que nos traducida a sql devolverá segun finalizado sea true/ false

    MateriaAprendizaje findByNombre(String nombre); //Nos permite buscar por el nombre 

}
