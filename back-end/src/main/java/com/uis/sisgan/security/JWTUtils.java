package com.uis.sisgan.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    public String extractEmailFromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SecurityConstants.SECRET_KEY)
                .build()
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }

}
