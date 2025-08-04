package com.santiago.api_libros.services;

import com.santiago.api_libros.entities.Autor;

import java.util.List;

public interface AutorService {
    Autor save(Autor autor);
    List<Autor> findAll();
    Autor findById(Integer id);
    void deleteById(Integer id);
    Autor update(Autor autor);
}
