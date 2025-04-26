package com.universidad.matriculas_servicio;

import com.universidad.matriculas_servicio.client.UsuarioClient;
import com.universidad.matriculas_servicio.client.AsignaturaClient;
import com.universidad.matriculas_servicio.model.MatriculaModel;
import com.universidad.matriculas_servicio.repository.MatriculaRepository;
import com.universidad.matriculas_servicio.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MatriculaServiceErrorTest {

    @Mock
    private MatriculaRepository matriculaRepository;

    @Mock
    private UsuarioClient usuarioClient;

    @Mock
    private AsignaturaClient asignaturaClient;

    @InjectMocks
    private MatriculaService matriculaService;

    private MatriculaModel matricula;

    @BeforeEach
    public void setUp() {
        matricula = new MatriculaModel(1L, 1L, 1L); // Creando una matrícula de ejemplo.
    }

    @Test
    public void testCrearMatriculaErrorRepositorio() {
        // Simula error al guardar en repo.
        when(matriculaRepository.save(matricula)).thenThrow(new RuntimeException("Error al guardar matrícula"));

        // Invocamos al metodo y simulamos excepcion.
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            matriculaService.crearMatricula(matricula);
        });

        // Valida mensaje de error en excepcion.
        assertEquals("Error al guardar matrícula", exception.getMessage());

        verify(matriculaRepository, times(1)).save(matricula);
        verify(usuarioClient, never()).getUsuarioPorId(1L);
        verify(asignaturaClient, never()).getAsignaturaPorId(1L);
    }
}
