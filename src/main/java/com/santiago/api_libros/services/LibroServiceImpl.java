package com.santiago.api_libros.services;

import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.entities.Libro;
import com.santiago.api_libros.repositories.AutorRepository;
import com.santiago.api_libros.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    };

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(Integer id) {
        return libroRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro update(Libro libro) {
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío.");
        }
        return libroRepository.save(libro);
    }

    @Override
    public Libro crearLibro(Libro libro, Integer idAutor){
      Autor autor = autorRepository.findById(idAutor).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
      libro.setAutor(autor);
      return libroRepository.save(libro);
    };
}
