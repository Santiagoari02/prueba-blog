package com.santiago.api_libros.services;

import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findById(Integer id) {
        return autorRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        autorRepository.deleteById(id);
    }

    @Override
    public Autor update(Autor autor) {
        if (autor.getNombre() == null || autor.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
        }
        if (autor.getApellido() == null || autor.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido del autor no puede estar vacío.");
        }
        if (autor.getGenero() == null || autor.getGenero().isEmpty()) {
            throw new IllegalArgumentException("El género del autor no puede estar vacío.");
        }
        return autorRepository.save(autor);
    }
}
