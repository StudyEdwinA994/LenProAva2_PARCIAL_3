package com.universidad.matriculas_servicio;

import com.universidad.matriculas_servicio.controller.MatriculaController;
import com.universidad.matriculas_servicio.model.MatriculaModel;
import com.universidad.matriculas_servicio.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MatriculaControllerUnitTest {

    @Mock
    private MatriculaService service;

    @InjectMocks
    private MatriculaController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarMatricula() {
        MatriculaModel matricula = new MatriculaModel(null, 1L, 1L);

        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("matricula", matricula);
        expectedResponse.put("usuario", new HashMap<>());
        expectedResponse.put("asignatura", new HashMap<>());

        // Simulando el servicio.
        when(service.crearMatricula(matricula)).thenReturn(expectedResponse);

        // Invocacion al controlador.
        Map<String, Object> actualResponse = controller.registrarMatricula(matricula);

        // Validacion.
        assertEquals(expectedResponse, actualResponse);
        verify(service, times(1)).crearMatricula(matricula);
    }
}
