package es.cic.curso25.RicardoMarcos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MateriaAprendizaje {
@Id
@GeneratedValue(strategy = GenerationType.AUTO) //Genera id AutoIncremental

private Long id;
private String nombre;
private boolean finalizado;

//El constructor que hay es el vacio por defecto
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public boolean isFinalizado() {
    return finalizado;
}
public void setFinalizado(boolean finalizado) {
    this.finalizado = finalizado;
}



}
