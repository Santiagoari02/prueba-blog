package com.santiago.api_libros.config;

import com.santiago.api_libros.dtos.LibroResponseDto;
import com.santiago.api_libros.entities.Libro;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuración para el mapeo del libro al DTO de respuesta
        modelMapper.typeMap(Libro.class, LibroResponseDto.class)
                .addMapping(src -> src.getAutor().getNombre(), LibroResponseDto::setNombre_autor)
                .addMapping(src -> src.getAutor().getApellido(), LibroResponseDto::setApellido_autor)
                .addMapping(Libro::getFecha_de_publicacion, LibroResponseDto::setFechaDePublicacion);;

        return modelMapper;
    }
}