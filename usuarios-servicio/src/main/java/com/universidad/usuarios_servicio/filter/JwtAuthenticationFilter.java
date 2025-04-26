package com.universidad.usuarios_servicio.filter;

import com.universidad.usuarios_servicio.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    //Constructor que inyecta el JWTSERVICE y valida token.
    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractTokenFromRequest(request);

        if (token != null && validateToken(token)) {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
        }

        filterChain.doFilter(request, response);
    }

    //Este metodo extrae el token de la solicitud.
    private String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // Este metodo valida el token con el servicio JwtService.
    private boolean validateToken(String token) {
        return jwtService.isValidToken(token);
    }

    // Este metodo me permite la autenticacion a partir del token.
    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        String username = jwtService.extractUsername(token);

        //Validacion de roles.
        if (username != null) {
            return new UsernamePasswordAuthenticationToken(username, null, null);
        }

        return null;
    }
}
