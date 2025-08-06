package com.santiago.api_libros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorResponseDto {
    private String nombre;
    private String apellido;
    private String fecha_de_nacimiento;
    private String genero;
    private List<LibroResponseDto> libros;
}
