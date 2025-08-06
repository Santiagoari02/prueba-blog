package com.santiago.api_libros.services;

import com.santiago.api_libros.dtos.LibroRequestDto;
import com.santiago.api_libros.dtos.LibroResponseDto;
import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.entities.Libro;

import java.util.List;

public interface LibroService {
    Libro save(Libro libro);
    List<Libro> findAll();
    Libro findById(Integer id);
    void deleteById(Integer id);
    LibroResponseDto update(LibroRequestDto libroRequest, Integer idLibro);
    LibroResponseDto crearLibro(LibroRequestDto libroRequest, Integer idAutor);
    LibroResponseDto findLibroById(Integer id);
    List<LibroResponseDto> findAllLibros();
}
