package com.universidad.usuarios_servicio.controller;

import com.universidad.usuarios_servicio.model.AuthRequest;
import com.universidad.usuarios_servicio.model.AuthResponse;
import com.universidad.usuarios_servicio.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    //Devolucion del token.
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authenticationService.authenticate(authRequest);
    }
}
