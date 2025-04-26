package com.universidad.asignaturas_servicio.service;

import com.universidad.asignaturas_servicio.model.AsignaturaModel;
import com.universidad.asignaturas_servicio.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository repository;

    public List<AsignaturaModel> listarAsignaturas() {
        return repository.findAll();
    }

    public AsignaturaModel guardarAsignatura(AsignaturaModel asignatura) {
        return repository.save(asignatura);
    }

    public AsignaturaModel obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
