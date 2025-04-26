package com.universidad.matriculas_servicio.service;

import com.universidad.matriculas_servicio.client.UsuarioClient;
import com.universidad.matriculas_servicio.client.AsignaturaClient;
import com.universidad.matriculas_servicio.model.MatriculaModel;
import com.universidad.matriculas_servicio.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private AsignaturaClient asignaturaClient;

    public Map<String, Object> crearMatricula(MatriculaModel matricula) {
        MatriculaModel nueva = repository.save(matricula);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("matricula", nueva);
        respuesta.put("usuario", usuarioClient.getUsuarioPorId(matricula.getUsuarioId()));
        respuesta.put("asignatura", asignaturaClient.getAsignaturaPorId(matricula.getAsignaturaId()));

        return respuesta;
    }
}
