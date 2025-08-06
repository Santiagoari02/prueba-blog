package com.santiago.api_libros.dtos;

import com.santiago.api_libros.entities.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDto {
    private String titulo;
    private LocalDate fecha_de_publicacion;
    private Autor autor;
}
