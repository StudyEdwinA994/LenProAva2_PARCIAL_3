package com.universidad.asignaturas_servicio;

import com.universidad.asignaturas_servicio.model.AsignaturaModel;
import com.universidad.asignaturas_servicio.repository.AsignaturaRepository;
import com.universidad.asignaturas_servicio.service.AsignaturaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaServiceTest2 {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaService asignaturaService;

    private AsignaturaModel asignatura;

    @BeforeEach
    public void setUp() {
        // Arranca los mocks.
        MockitoAnnotations.openMocks(this);

        // Inicializa el objeto porque se genera automatico.
        asignatura = new AsignaturaModel(null, "Física", "Descripción de Física", 4);
    }

    @Test
    public void testGuardarAsignatura() {
        when(asignaturaRepository.save(asignatura)).thenReturn(new AsignaturaModel(1L, "Física", "Descripción de Física", 4));

        // Invoca el metodo servicio.
        AsignaturaModel asignaturaGuardada = asignaturaService.guardarAsignatura(asignatura);

        // Verifica que no sea nula.
        assertNotNull(asignaturaGuardada);

        // Verifica ID correcto.
        assertEquals(1L, asignaturaGuardada.getId());

        // Verifica nombre correcto.
        assertEquals("Física", asignaturaGuardada.getNombre());

        // Verifica creditos correctos.
        assertEquals(4, asignaturaGuardada.getCreditos());

        // Verifica que no se haya llamado al metodo save.
        verify(asignaturaRepository, times(1)).save(asignatura);
    }
}
