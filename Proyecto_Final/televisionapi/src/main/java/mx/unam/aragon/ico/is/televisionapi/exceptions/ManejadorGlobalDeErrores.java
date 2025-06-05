package mx.unam.aragon.ico.is.televisionapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<HashMap<String, String>>
            handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        HashMap<String, String> errors = new HashMap<>();
        errors.put("Timestamp" , LocalDateTime.now().toString());
        errors.put("Message" , "Error al validad los datos");
        errors.put("Codigo" , "2004");
        return new ResponseEntity<>(errors , org.springframework.http.HttpStatus.OK );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>>
    handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        HashMap<String, String> errors = new HashMap<>();
        errors.put("Timestamp" , LocalDateTime.now().toString());
        errors.put("Message" , "La peticion no tiene la estructura correcta");
        errors.put("Codigo" , "2000");
        return new ResponseEntity<>(errors , org.springframework.http.HttpStatus.OK );
    }
}











