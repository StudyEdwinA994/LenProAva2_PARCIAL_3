package com.universidad.usuarios_servicio.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "Zy4Fx4QXMW4mpzlfYbd0U6G5Z+C9D9v5W/AgpvQ0ylQ=";

    // Este metodo extrae el token del usuario.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Este metodo valida el token.
    public boolean isValidToken(String token) {
        String username = extractUsername(token);
        Date expirationDate = extractExpiration(token);
        return username != null && expirationDate != null && expirationDate.after(new Date());
    }

    public <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

        private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Este metodo revisa la fecha de caducacion del token.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    @FunctionalInterface
    interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
