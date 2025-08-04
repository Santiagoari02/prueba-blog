package com.santiago.api_libros.controllers;

import com.santiago.api_libros.entities.Libro;
import com.santiago.api_libros.services.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@Tag(name = "Libros", description = "Endpoints para la gestión de los libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService){
      this.libroService = libroService;
    };

    @Operation(summary = "Crea un nuevo libro", description = "Recibe una entidad de libro y lo guarda en la base de datos, asociándolo a un autor.")
    @ApiResponse(responseCode = "201", description = "Libro creado exitosamente.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.")
    @ApiResponse(responseCode = "404", description = "Autor no encontrado.")
    @PostMapping("/{idAutor}")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro save(@RequestBody Libro libro, @Parameter(description = "El ID del autor a asignar", example = "1") @PathVariable Integer idAutor){
      return libroService.crearLibro(libro, idAutor);
    };

    @GetMapping
    public List<Libro> findAll(){
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro findById(@PathVariable Integer id){
        return libroService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        libroService.deleteById(id);
    }

    @PutMapping("/{idLibro}")
    public Libro updateLibro(@RequestBody Libro libro, @PathVariable Integer idLibro){
      Libro libroDb = libroService.findById(idLibro);
      libroDb.setTitulo(libro.getTitulo());
      return libroService.update(libroDb);
    }
}
