package com.universidad.usuarios_servicio.service;

import com.universidad.usuarios_servicio.model.AuthRequest;
import com.universidad.usuarios_servicio.model.AuthResponse;
import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.repository.UsuarioRepository;
import com.universidad.usuarios_servicio.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse authenticate(AuthRequest authRequest) {
        // Se encarga de buscar el usuario por correo.
        UsuarioModel usuario = usuarioRepository.findByCorreo(authRequest.getCorreo()).orElse(null);

        // Verificacion de la existencia del usuario.
        if (usuario != null) {
            // Loguear los datos para la depuración
            System.out.println("Usuario encontrado: " + usuario.getCorreo());
            System.out.println("Contraseña enviada: " + authRequest.getContraseña());
            System.out.println("Contraseña almacenada: " + usuario.getContraseña());

            // Comparacion de contrasenas.
            if (authRequest.getContraseña().equals(usuario.getContraseña())) {
                System.out.println("Contraseña válida. Generando token...");

                // Generacion de token JWT.
                String token = jwtUtil.generarToken(usuario.getCorreo());
                return new AuthResponse(token); // Retorna el token JWT
            } else {
                // Error si no coinciden los password.
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            // Error si no encuentra los usuarios.
            System.out.println("Usuario no encontrado en la base de datos.");
        }

        // No encuentra el usuario y contrasena incorrecta.
        throw new RuntimeException("Credenciales inválidas");
    }
}
