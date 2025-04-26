package com.universidad.asignaturas_servicio.controller;

import com.universidad.asignaturas_servicio.model.AsignaturaModel;
import com.universidad.asignaturas_servicio.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService service;

    @GetMapping
    public List<AsignaturaModel> obtenerAsignaturas() {
        return service.listarAsignaturas();
    }

    @PostMapping
    public AsignaturaModel crearAsignatura(@RequestBody AsignaturaModel asignatura) {
        return service.guardarAsignatura(asignatura);
    }

    //Se encarga de devolver 404 si no lo encuentra o 202 si encuentra la asignatura.
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaModel> obtenerPorId(@PathVariable Long id) {
        AsignaturaModel asignatura = service.obtenerPorId(id);
        if (asignatura == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(asignatura);
    }
}
