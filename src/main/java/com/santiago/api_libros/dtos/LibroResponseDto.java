package com.santiago.api_libros.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroResponseDto {
    private String titulo;
    private LocalDate fechaDePublicacion;
    private String nombre_autor;
    private String apellido_autor;

    public String getNombre_completo_autor() {
        if (nombre_autor != null && apellido_autor != null) {
            return nombre_autor + " " + apellido_autor;
        }
        return null;
    }

    public String getAntiguedad() {
        if (this.fechaDePublicacion != null) {
            int years = Period.between(this.fechaDePublicacion, LocalDate.now()).getYears();
            return years + " años";
        }
        return null;
    }
}
