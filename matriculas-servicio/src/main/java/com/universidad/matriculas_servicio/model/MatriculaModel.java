package com.universidad.matriculas_servicio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculas")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long asignaturaId;

    public MatriculaModel() {}

    public MatriculaModel(Long id, Long usuarioId, Long asignaturaId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
    }

    // Getter y Setter.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getAsignaturaId() { return asignaturaId; }
    public void setAsignaturaId(Long asignaturaId) { this.asignaturaId = asignaturaId; }
}
