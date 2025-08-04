package com.santiago.api_libros.controllers;

import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.services.AutorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Endpoints para la gestión de los autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    };

    @GetMapping
    public List<Autor> findAll(){
        return autorService.findAll();
    };

    @GetMapping("/{id}")
    public Autor findById(@PathVariable Integer id){
        return autorService.findById(id);
    };

    @PostMapping
    public Autor save(@RequestBody Autor autor){
        return autorService.save(autor);
    };

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        autorService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Autor updateById(@RequestBody Autor autor, @PathVariable Integer id){
        Autor autorDb = autorService.findById(id);
        autorDb.setNombre(autor.getNombre());
        autorDb.setApellido(autor.getApellido());
        autorDb.setGenero(autor.getGenero());
        return autorService.update(autorDb);
    };
}
