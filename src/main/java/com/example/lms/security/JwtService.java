package com.example.lms.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import com.example.lms.core.user.User;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service //Do not change this hardcoded key pls paarth or anyone 
public class JwtService { //This is a random hardcoded jwt key , pls use a diff key for production
    private static final String SECRET_KEY = "ee05c8dde4181f50d3fe7e03975921f2f559abb7a8bcc67ca7dc106f50a8c5489f3e42dcb08812c23d0afe20ab5c2fb1576455c10978fa8f96ae79b0fc5318de28d2a2202a99500287546f687fd2d203c3e674170712aef30cdfaa5c852a3cb812fe6a2fcabfec4f5c1aa4126353b2cf3e80967e8fee581afab76fec283bc40397f1605fac570c24ff4abe4e613222d533d8354436be770efe7c7ac72f9fa4acba4432f29076283db69b515e55036911891340be0ac6b189280c731b11c45b62f63f3ddfa02b82982ebcbeb2254955cde7c040b9868d5cc9d3fbe2c488095802fa634f40e3a5e21d57179b3a9884e6821ded00d8a9c1efba0380520b27a3e9aa";
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch ( JwtException e) {
            return false;
        }
    }
}
// This Creates a Jwt token and validates when signing in