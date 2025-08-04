package com.santiago.api_libros.controllers;

import com.santiago.api_libros.controllers.LibroController;
import com.santiago.api_libros.entities.Libro;
import com.santiago.api_libros.services.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class) // Prueba solo la capa web
public class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // Simula el servicio, ya que la prueba no debe depender de su implementación real
    private LibroService libroService;

    @Test
    void testGetLibroById() throws Exception {
        // 1. Configurar datos de prueba
        Libro Libro = new Libro();
        Libro.setId_libro(1);
        Libro.setTitulo("Demian");

        // 2. Simular el comportamiento del servicio
        when(libroService.findById(1)).thenReturn(Libro);

        // 3. Ejecutar la petición con MockMvc y verificar el resultado
        mockMvc.perform(get("/api/libros/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_libro").value(1))
                .andExpect(jsonPath("$.titulo").value("Demian"));
    }
}