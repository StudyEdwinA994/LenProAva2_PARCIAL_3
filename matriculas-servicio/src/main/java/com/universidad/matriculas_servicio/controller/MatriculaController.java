package com.universidad.matriculas_servicio.controller;

import com.universidad.matriculas_servicio.model.MatriculaModel;
import com.universidad.matriculas_servicio.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @PostMapping
    public Map<String, Object> registrarMatricula(@RequestBody MatriculaModel matricula) {
        return service.crearMatricula(matricula);
    }
}
