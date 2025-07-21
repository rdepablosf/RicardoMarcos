package es.cic.curso25.RicardoMarcos.exception;

public class MateriaDuplicadaException extends RuntimeException {

    public MateriaDuplicadaException(String nombre) {
        super("Ya existe una materia con el nombre: " + nombre);
    }
}
