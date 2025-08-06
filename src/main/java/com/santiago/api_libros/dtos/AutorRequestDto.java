package com.santiago.api_libros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorRequestDto {
    private String nombre;
    private String apellido;
    private String genero;
}
