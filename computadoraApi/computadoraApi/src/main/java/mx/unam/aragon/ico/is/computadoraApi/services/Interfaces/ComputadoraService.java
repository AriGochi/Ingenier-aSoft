package mx.unam.aragon.ico.is.computadoraApi.services.Interfaces;

import mx.unam.aragon.ico.is.computadoraApi.entitys.Computadora;

import java.util.Optional;

public interface ComputadoraService {
    public abstract Computadora crear(Computadora computadora);
    public abstract Iterable<Computadora> listarTodas();
    public abstract Optional<Computadora> buscarPorId(Long clave);
    public abstract Computadora actualizar(Long clave, Computadora computadora);
    public abstract Computadora eliminar(Long clave);
}