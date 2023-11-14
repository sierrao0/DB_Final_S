package com.puj.sierrafinal.dto;

import java.util.Iterator;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LibroDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String autor;
    private Long biblioteca_id;


    public LibroDTO() {
        super();
        this.id = null;
        this.nombre = null;
        this.autor = null;
        this.biblioteca_id = null;
    }

    public LibroDTO(Long id, String nombre, String autor, Long biblioteca_id) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca_id = biblioteca_id;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getBiblioteca_id() {
        return this.biblioteca_id;
    }

    public void setBiblioteca_id(Long biblioteca_id) {
        this.biblioteca_id = biblioteca_id;
    }
    
    public JSONObject toJSON() throws Exception {
        JSONObject japplication = new JSONObject();
        japplication.put("id", getId());
        japplication.put("name", getNombre());
        japplication.put("autor", getAutor());
        japplication.put("biblioteca", getBiblioteca_id());
        return japplication;
    }

    public static JSONArray toJSONArray( Iterable<LibroDTO> libros) throws Exception {
        JSONArray jlibros = new JSONArray();
        Iterator<LibroDTO> ilibros = libros.iterator();
        while(ilibros.hasNext()) {
            LibroDTO libro = ilibros.next();
            jlibros.put(libro.toJSON());
        }
        return jlibros;
    }
}
