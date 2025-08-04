package com.santiago.api_libros.services;

import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.entities.Libro;

import java.util.List;

public interface LibroService {
    Libro save(Libro libro);
    List<Libro> findAll();
    Libro findById(Integer id);
    void deleteById(Integer id);
    Libro update(Libro libro);
    Libro crearLibro(Libro libro, Integer idAutor);
}
