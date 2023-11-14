package com.puj.sierrafinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.puj.sierrafinal.model.Biblioteca;
import com.puj.sierrafinal.model.BibliotecaRepository;

@RestController
public class BibliotecaController {
    @Autowired
    BibliotecaRepository bibliotecaRepository;

    @CrossOrigin
    @PostMapping(value = "/bibliotecas/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBiblioteca(@RequestBody Biblioteca newBiblioteca) throws Exception {
        bibliotecaRepository.save(newBiblioteca);
        HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/bibliotecas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllbibliotecas() throws Exception {
        List<Biblioteca> bibliotecas = (List<Biblioteca>) bibliotecaRepository.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(Biblioteca.toJSONArray(bibliotecas).toString(), responseHeaders, HttpStatus.OK);
    }
}
