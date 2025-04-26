package com.universidad.asignaturas_servicio;

import com.universidad.asignaturas_servicio.model.AsignaturaModel;
import com.universidad.asignaturas_servicio.repository.AsignaturaRepository;
import com.universidad.asignaturas_servicio.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AsignaturaServiceTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaService asignaturaService;

    @Test
    public void testListarAsignaturas() {
        AsignaturaModel asignatura1 = new AsignaturaModel(1L, "Matemáticas", "Descripción de Matemáticas", 5);
        AsignaturaModel asignatura2 = new AsignaturaModel(2L, "Física", "Descripción de Física", 4);

        //Simula el repo.
        Mockito.when(asignaturaRepository.findAll()).thenReturn(Arrays.asList(asignatura1, asignatura2));

        //Invoca al método del servicio.
        List<AsignaturaModel> asignaturas = asignaturaService.listarAsignaturas();

        //Verifica tamaño de la lista sea 2.
        assertEquals(2, asignaturas.size());
    }

    @Test
    public void testGuardarAsignatura() {
        AsignaturaModel asignatura = new AsignaturaModel(1L, "Química", "Descripción de Química", 3);

        //Simula el repo.
        Mockito.when(asignaturaRepository.save(asignatura)).thenReturn(asignatura);

        //Invoca al método del servicio.
        AsignaturaModel result = asignaturaService.guardarAsignatura(asignatura);

        //Verifica nombre de la asignatura "Química".
        assertEquals("Química", result.getNombre());
    }

    @Test
    public void testObtenerPorId() {
        AsignaturaModel asignatura = new AsignaturaModel(1L, "Biología", "Descripción de Biología", 4);

        //Simula el repo.
        Mockito.when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(asignatura));

        //Invoca al método del servicio.
        AsignaturaModel result = asignaturaService.obtenerPorId(1L);

        //Verifica nombre de la asignatura "Biología".
        assertEquals("Biología", result.getNombre());
    }

    //Simula que no encuentra la asignatura - valida resultado null.
    @Test
    public void testObtenerPorIdNoEncontrado() {
        Mockito.when(asignaturaRepository.findById(1L)).thenReturn(Optional.empty());

        AsignaturaModel result = asignaturaService.obtenerPorId(1L);

        assertNull(result);
    }
}
