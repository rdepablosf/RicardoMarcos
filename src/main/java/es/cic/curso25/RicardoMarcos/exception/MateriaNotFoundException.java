package es.cic.curso25.RicardoMarcos.exception;

public class MateriaNotFoundException extends RuntimeException{

    public MateriaNotFoundException(Long id){
        super("No se encontró la materia con id: "+ id);
    }
}
