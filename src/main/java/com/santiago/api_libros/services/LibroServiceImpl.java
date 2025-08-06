package com.santiago.api_libros.services;

import com.santiago.api_libros.dtos.LibroRequestDto;
import com.santiago.api_libros.dtos.LibroResponseDto;
import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.entities.Libro;
import com.santiago.api_libros.repositories.AutorRepository;
import com.santiago.api_libros.repositories.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService{

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final ModelMapper modelMapper;

    public LibroServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository, ModelMapper modelMapper){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.modelMapper = modelMapper;
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
    public LibroResponseDto update(LibroRequestDto libroRequest, Integer idLibro) {
        Libro libroDb = findById(idLibro);
        libroDb.setTitulo(libroRequest.getTitulo());
        if (libroRequest.getTitulo() == null || libroRequest.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío.");
        }
        Libro libroEditado = libroRepository.save(libroDb);
        return modelMapper.map(libroEditado, LibroResponseDto.class);
    }

    @Override
    public LibroResponseDto crearLibro(LibroRequestDto libroRequest, Integer idAutor){
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Libro nuevoLibro = modelMapper.map(libroRequest, Libro.class);
        nuevoLibro.setAutor(autor);
        Libro libroGuardado = libroRepository.save(nuevoLibro);
        return modelMapper.map(libroGuardado, LibroResponseDto.class);
    };

    @Override
    public List<LibroResponseDto> findAllLibros(){
        List<Libro> libros = libroRepository.findAll();
        return libros.stream()
                .map(libro -> modelMapper.map(libro, LibroResponseDto.class))
                .collect(Collectors.toList());
    };

    @Override
    public LibroResponseDto findLibroById(Integer id) {
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el libro."));
        return modelMapper.map(libro, LibroResponseDto.class);
    }
}
