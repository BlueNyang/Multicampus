package kr.bluenyang.practice.springbootsecure.jwt.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import kr.bluenyang.practice.springbootsecure.jwt.domain.JwtProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey key;
    private final long accessTokenValidityMs; // 1Day to ms
    private final String tokenPrefix = "Bearer ";

    public JwtService(JwtProperties jwtProperties) {
        String secretString = jwtProperties.secret();
        this.accessTokenValidityMs = jwtProperties.accessTokenValidityMs();

        this.key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    public String getToken(String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + accessTokenValidityMs))
                .signWith(this.key)
                .compact();
    }

    public String getAuthUser(HttpServletRequest req) {
        String token = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null) {
            return Jwts.parser()
                    .verifyWith(this.key)
                    .build()
                    .parseSignedClaims(token.replace("Bearer ", ""))
                    .getPayload()
                    .getSubject();
        }
        return null;
    }
}
