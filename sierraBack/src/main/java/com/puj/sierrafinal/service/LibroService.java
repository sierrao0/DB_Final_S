package com.puj.sierrafinal.service;

import org.springframework.stereotype.Service;

import com.puj.sierrafinal.model.Libro;
import com.puj.sierrafinal.model.LibroRepository;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public LibroRepository getRepository() {
        return this.libroRepository;
    }

    public Libro getBookById(Long LibroID) {
        return libroRepository.findById(LibroID).orElse(null);
    }

    public void saveBook(Libro libro) {
        libroRepository.save(libro);
    }
}
