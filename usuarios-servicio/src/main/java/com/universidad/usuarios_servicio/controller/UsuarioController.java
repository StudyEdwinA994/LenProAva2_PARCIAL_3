package com.universidad.usuarios_servicio.controller;

import com.universidad.usuarios_servicio.model.UsuarioModel;
import com.universidad.usuarios_servicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioModel> obtenerUsuarios() {
        return service.listarUsuarios();
    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario) {
        return service.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioModel obtenerUsuarioPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/todos")
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return service.listarUsuarios();
    }

}
