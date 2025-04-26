package com.universidad.matriculas_servicio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio", url = "${usuarios-servicio.url}")
public interface UsuarioClient {
    @GetMapping("/usuarios/{id}")
    Object getUsuarioPorId(@PathVariable("id") Long id);
}

