package com.universidad.usuarios_servicio;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.repository.UsuarioRepository;
import com.universidad.usuarios_servicio.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UsuarioModel usuario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new UsuarioModel(1L, "Juan", "juan@ejemplo.com", "Estudiante", "contraseña123");
    }

    @Test
    public void testListarUsuarios() {
        // Simulacion de vista con 1 usuario.
        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        var usuarios = usuarioService.listarUsuarios();

        // Validacion de lista con usuario esperado.
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(1, usuarios.size());
        assertEquals("Juan", usuarios.get(0).getNombre());

        // Invocacion al repo.
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    public void testGuardarUsuario() {
        // Repo guarda el usuario y lo devuelve.
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Invocamos al metodo del servicio.
        UsuarioModel usuarioGuardado = usuarioService.guardarUsuario(usuario);

        // Validamos coincidencia en usuarios.
        assertNotNull(usuarioGuardado);
        assertEquals("Juan", usuarioGuardado.getNombre());

        // Validacion sobre el llamado al repo.
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    public void testObtenerPorId() {
        // Simula usuario encontrado por ID.
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioModel usuarioEncontrado = usuarioService.obtenerPorId(1L);

        assertNotNull(usuarioEncontrado);
        assertEquals("Juan", usuarioEncontrado.getNombre());

        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    public void testObtenerPorIdNoExistente() {
        // Simula que el usuario no existe o no esta creado.
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            usuarioService.obtenerPorId(1L);
        });

        assertEquals("Usuario no encontrado con el ID: 1", exception.getMessage());

        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    public void testObtenerUsuarioPorCorreo() {
        // Simula que el usuario si existe y esta creado.
        when(usuarioRepository.findByCorreo("juan@ejemplo.com")).thenReturn(Optional.of(usuario));


        UsuarioModel usuarioEncontrado = usuarioService.obtenerUsuarioPorCorreo("juan@ejemplo.com");

        assertNotNull(usuarioEncontrado);
        assertEquals("Juan", usuarioEncontrado.getNombre());

        verify(usuarioRepository, times(1)).findByCorreo("juan@ejemplo.com");
    }

    @Test
    public void testObtenerUsuarioPorCorreoNoExistente() {
        // Simula que no encuentra usuario por correo
        when(usuarioRepository.findByCorreo("juan@ejemplo.com")).thenReturn(Optional.empty());

        UsuarioModel usuarioEncontrado = usuarioService.obtenerUsuarioPorCorreo("juan@ejemplo.com");

        // Valida sino duevuelve null
        assertNull(usuarioEncontrado);

        verify(usuarioRepository, times(1)).findByCorreo("juan@ejemplo.com");
    }
}
