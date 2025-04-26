package com.universidad.matriculas_servicio.repository;

import com.universidad.matriculas_servicio.model.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
}
