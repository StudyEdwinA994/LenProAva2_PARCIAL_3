package com.universidad.usuarios_servicio.repository;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByCorreo(String correo); //Metodo donde busco por el correo.
}
