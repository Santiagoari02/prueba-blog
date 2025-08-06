package com.santiago.api_libros.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
@Schema(description = "Schema para la tabla libro.")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "El ID del libro, generado automáticamente", example = "10", readOnly = true)
    private Integer id_libro;
    @Schema(description = "El título del libro", example = "Cien años de soledad", requiredMode = Schema.RequiredMode.REQUIRED)
    private String titulo;
    private LocalDate fecha_de_publicacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
