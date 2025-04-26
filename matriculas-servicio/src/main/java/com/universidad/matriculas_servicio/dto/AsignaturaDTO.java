package com.universidad.matriculas_servicio.dto;

public class AsignaturaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private int creditos;

    public AsignaturaDTO() {}

    public Long getId() {
        return id;
    }

    //Getter y Setter.
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}

