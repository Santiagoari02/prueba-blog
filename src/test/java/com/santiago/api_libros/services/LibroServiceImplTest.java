package com.santiago.api_libros.services;

import com.santiago.api_libros.entities.Autor;
import com.santiago.api_libros.entities.Libro;
import com.santiago.api_libros.repositories.LibroRepository;
import com.santiago.api_libros.services.LibroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibroServiceImplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    @Test
    void testGetLibroById_Success() {
        // 1. Configurar datos de prueba
        Autor autor = new Autor();
        autor.setId_autor(1);

        Libro libro = new Libro();
        libro.setId_libro(1);
        libro.setTitulo("Demian");
        libro.setAutor(autor);

        // 2. Definir el comportamiento simulado del repositorio
        when(libroRepository.findById(1)).thenReturn(Optional.of(libro));

        // 3. Llamar al método que estamos probando
        Libro result = libroService.findById(1);

        // 4. Afirmar el resultado esperado
        assertEquals("Demian", result.getTitulo());
        assertEquals(1, result.getId_libro());
    }

    @Test
    void testGetLibroById_NotFound() {
        // 1. Configurar el comportamiento para un ID inexistente
        when(libroRepository.findById(99)).thenReturn(Optional.empty());

        // 2. Afirmar que se lanza una excepción cuando el libro no existe
        assertThrows(RuntimeException.class, () -> libroService.findById(99));
    }
}