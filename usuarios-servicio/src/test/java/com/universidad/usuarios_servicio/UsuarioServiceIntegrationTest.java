package com.universidad.usuarios_servicio;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.repository.UsuarioRepository;
import com.universidad.usuarios_servicio.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UsuarioServiceIntegrationTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        // Limpia base de datos para probar.
        usuarioRepository.deleteAll();

        // Agrega el usuario.
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@universidad.com");
        usuario.setTipo("Estudiante");
        usuario.setContraseña("1234");

        usuarioRepository.save(usuario);
    }

    @Test
    public void testObtenerUsuarioPorCorreo() {
        // Busco usuario por correo.
        UsuarioModel usuario = usuarioService.obtenerUsuarioPorCorreo("juan.perez@universidad.com");

        // Usuario diferente de null (puede pasar).
        assertNotNull(usuario);
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("juan.perez@universidad.com", usuario.getCorreo());
        assertEquals("Estudiante", usuario.getTipo());
    }
}
