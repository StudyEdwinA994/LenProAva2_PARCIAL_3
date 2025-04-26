package com.universidad.usuarios_servicio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String tipo;
    private String contraseña;

    public UsuarioModel() {}

    public UsuarioModel(Long id, String nombre, String correo, String tipo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }

    //Getter y setter.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
