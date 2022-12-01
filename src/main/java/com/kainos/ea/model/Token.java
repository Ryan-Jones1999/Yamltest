package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Token {
    protected String token;

    public void generateToken(User user) {
        String secret = System.getenv("JWT_SECRET_TOKEN");

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
        this.token = jwtToken;
    }

    public String decryptToken() {
        String secret = System.getenv("JWT_SECRET_TOKEN");


        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(this.token);
        return jwt.toString();
    }

    @JsonCreator
    public Token(@JsonProperty("token") String token) {
        this.setToken(token);
    }
}
