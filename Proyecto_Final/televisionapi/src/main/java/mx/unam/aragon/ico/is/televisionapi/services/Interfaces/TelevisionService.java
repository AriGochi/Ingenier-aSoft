package mx.unam.aragon.ico.is.televisionapi.services.Interfaces;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;

import java.util.Optional;

public interface TelevisionService {
    public abstract Television crear(Television television);
    public abstract Iterable<Television> listarTodas();
    public abstract Optional<Television> buscarPorId(Integer clave);
    public abstract Television actualizar(Integer clave , Television television);
    public abstract void eliminar(Integer clave);

}
