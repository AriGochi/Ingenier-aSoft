package mx.unam.aragon.ico.is.televisionapi.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import mx.unam.aragon.ico.is.televisionapi.services.Interfaces.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/televisiones")
public class TelevisionController {

    @Autowired
    private TelevisionService televisionService;

    @GetMapping
    public ResponseEntity<Iterable<Television>> getTelevisiones(){
        return ResponseEntity.ok().body(televisionService.listarTodas());
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Television> getTelevision(@PathVariable Integer clave){
        //return televisionService.buscarPorId(clave).orElse(null);
        return ResponseEntity.ok(televisionService.buscarPorId(clave).orElse(null));
    }

    @PostMapping("/Crear")
    public ResponseEntity<Television> crearTelevision(@Valid @RequestBody Television television) throws URISyntaxException {
        //return televisionService.crear(television);
        return ResponseEntity.created(new URI("http://localhost:8080/api/v1/televisiones")).body(televisionService.crear(television));
    }

    @PutMapping("/Cambiar/{clave}")
    public ResponseEntity<Television>
        updateTelevision(@PathVariable Integer clave,@Valid @RequestBody Television television) {
        return ResponseEntity.ok(televisionService.actualizar(clave, television));
    }

    @PatchMapping("/actualizar/{clave}")
    public ResponseEntity<Television>
    patchTelevision(@PathVariable Integer clave, @RequestBody Television television) {
        Optional<Television> tmp = televisionService.buscarPorId(clave);
        if(tmp.isPresent()){
            Television actual= tmp.get();
            if(television.getModelo() != null) actual.setModelo(television.getModelo());
            if(television.getFoto() != null) actual.setFoto(television.getFoto());
            if(television.getPrecio() != null) actual.setPrecio(television.getPrecio());
            if(television.getMarca() != null) actual.setMarca(television.getMarca());
            return ResponseEntity.ok(televisionService.actualizar(clave,actual));
            }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrar/{clave}")
    public void deleteTelevision(@PathVariable Integer clave){
        televisionService.eliminar(clave);
    }


}
