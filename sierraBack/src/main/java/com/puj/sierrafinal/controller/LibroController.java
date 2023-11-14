package com.puj.sierrafinal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.puj.sierrafinal.model.Libro;
import com.puj.sierrafinal.model.LibroRepository;

@RestController
public class LibroController {
    @Autowired
    LibroRepository libroRepository;

    @CrossOrigin
    @PostMapping(value = "/libros/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createLibro(@RequestBody Libro newLibro) throws Exception {
        libroRepository.save(newLibro);
        HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }
    
    @CrossOrigin
    @GetMapping(value = "/libros", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAlllibros() throws Exception{
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(Libro.toJSONArray(libros).toString(), responseHeaders, HttpStatus.OK);
    }
}
