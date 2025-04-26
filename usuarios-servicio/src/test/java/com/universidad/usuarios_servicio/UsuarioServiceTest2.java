package com.universidad.usuarios_servicio;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.repository.UsuarioRepository;
import com.universidad.usuarios_servicio.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest2 {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UsuarioModel usuario;

    @BeforeEach
    public void setUp() {
        usuario = new UsuarioModel(1L, "Juan Pérez", "juan.perez@universidad.com", "Estudiante", "1234");
    }

    @Test
    public void testGuardarUsuario() {
        // Simulando el guardado exitoso en el repo.
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Invocamos el metodo para guardar.
        UsuarioModel usuarioGuardado = usuarioService.guardarUsuario(usuario);

        // Se valida que el usuario o alguno de sus datos no sea nulo,.
        assertNotNull(usuarioGuardado);
        assertEquals("Juan Pérez", usuarioGuardado.getNombre());
        assertEquals("juan.perez@universidad.com", usuarioGuardado.getCorreo());
        assertEquals("Estudiante", usuarioGuardado.getTipo());

        // Validamos que se guardo en el repo.
        verify(usuarioRepository, times(1)).save(usuario);
    }
}
