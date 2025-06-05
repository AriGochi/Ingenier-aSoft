package mx.unam.aragon.ico.is.televisionapi.repositories;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TelevisionRepository extends JpaRepository<Television, Integer> {

    public Television findTelevisionByClave(Integer clave);
    public Television deleteByClave(Integer clave);

}
