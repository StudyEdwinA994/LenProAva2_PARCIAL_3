package com.universidad.matriculas_servicio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "${asignaturas-servicio.url}")
public interface AsignaturaClient {
    @GetMapping("/asignaturas/{id}")
    Object getAsignaturaPorId(@PathVariable("id") Long id);
}
