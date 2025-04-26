package com.universidad.asignaturas_servicio.repository;

import com.universidad.asignaturas_servicio.model.AsignaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<AsignaturaModel, Long> {
}
