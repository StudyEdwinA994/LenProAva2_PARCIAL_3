package com.universidad.usuarios_servicio.service;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listo los usuario
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Guardo los usuarios.
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Busco por ID.
    public UsuarioModel obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + id));
    }

    // Usuario por el correo.
    public UsuarioModel obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null);
    }
}
