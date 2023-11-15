package com.puj.sierrafinal.service;

import org.springframework.stereotype.Service;

import com.puj.sierrafinal.model.Biblioteca;
import com.puj.sierrafinal.model.BibliotecaRepository;

@Service
public class BibliotecaService {
    private final BibliotecaRepository libraryRepository;

    public BibliotecaService(BibliotecaRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Biblioteca getLibraryById(Long libraryId) {
        return libraryRepository.findById(libraryId).orElse(null);
    }

    public void saveLibrary(Biblioteca library) {
        libraryRepository.save(library);
    }

    public void updateLibrary(Long libraryId, Biblioteca updatedLibrary) {
        Biblioteca existingLibrary = libraryRepository.findById(libraryId).orElse(null);

        if (existingLibrary != null) {
            existingLibrary.setNombre(updatedLibrary.getNombre());
            existingLibrary.setDireccion(updatedLibrary.getDireccion());
            existingLibrary.setCiudad(updatedLibrary.getCiudad());

            libraryRepository.save(existingLibrary);
        }
    }

    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
