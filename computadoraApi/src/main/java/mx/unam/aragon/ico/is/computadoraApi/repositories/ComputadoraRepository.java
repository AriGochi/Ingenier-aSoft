package mx.unam.aragon.ico.is.computadoraApi.repositories;

import mx.unam.aragon.ico.is.computadoraApi.entitys.Computadora;
import org.springframework.data.repository.CrudRepository;

public interface ComputadoraRepository extends CrudRepository<Computadora, Long> {

    public Computadora findComputadoraByClave(Long clave);
}
