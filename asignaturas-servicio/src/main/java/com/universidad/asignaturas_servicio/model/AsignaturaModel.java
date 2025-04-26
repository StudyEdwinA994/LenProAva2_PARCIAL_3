package com.universidad.asignaturas_servicio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class AsignaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private int creditos;

    public AsignaturaModel() {}

    //Constructor.
    public AsignaturaModel(Long id, String nombre, String descripcion, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }

    //Getter y Setter.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
}
