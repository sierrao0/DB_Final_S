package com.puj.sierrafinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Iterator;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;

    public Biblioteca(){
        super();
        this.id = null;
        this.nombre = null;
        this.direccion = null;
        this.ciudad = null;
    }

    public Biblioteca(Long id, String nombre, String direccion, String ciudad){
        super();
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
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

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject japplication = new JSONObject();
        japplication.put("id", getId());
        japplication.put("name", getNombre());
        japplication.put("direccion", getDireccion());
        japplication.put("ciudad", getCiudad());
        return japplication;
    }

    public static JSONArray toJSONArray( Iterable<Biblioteca> bibliotecas) throws Exception {
        JSONArray jbibliotecas = new JSONArray();
        Iterator<Biblioteca> ibibliotecas = bibliotecas.iterator();
        while(ibibliotecas.hasNext()) {
            Biblioteca biblioteca = ibibliotecas.next();
            jbibliotecas.put(biblioteca.toJSON());
        }
        return jbibliotecas;
    }
}
