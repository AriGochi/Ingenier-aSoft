package mx.unam.aragon.ico.is.computadoraApi.controllers;

import mx.unam.aragon.ico.is.computadoraApi.entitys.Computadora;
import mx.unam.aragon.ico.is.computadoraApi.services.Interfaces.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/computadoras")
public class ComputadoraController {
    @Autowired
    private ComputadoraService computadoraService;

    @GetMapping
    public ResponseEntity<Iterable<Computadora>> getComputadoras(){
        //return computadoraService.listarTodas();
        //return new ResponseEntity<>(computadoraService.listarTodas(), HttpStatus.CREATED);
        return ResponseEntity.ok().body(computadoraService.listarTodas());
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Computadora> getComputadora(@PathVariable Long clave){
        //return computadoraService.buscarPorId(clave).orElse(null);
        return ResponseEntity.ok(computadoraService.buscarPorId(clave).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Computadora> crearComputadora(@RequestBody Computadora computadora) throws URISyntaxException {
        //return computadoraService.crear(computadora);
        return ResponseEntity.created(new URI("http://localhost:8080/api/v1/computadoras")).body(computadoraService.crear(computadora));
    }
}
