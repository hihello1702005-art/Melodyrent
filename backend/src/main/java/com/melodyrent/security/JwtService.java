package com.melodyrent.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
@Service
public class JwtService {
  @Value("${app.jwt.secret}") private String secret;
  @Value("${app.jwt.access-token-minutes}") private long accessMinutes;
  @Value("${app.jwt.refresh-token-days}") private long refreshDays;
  public String accessToken(UserDetails user){ return token(user.getUsername(), accessMinutes*60); }
  public String refreshToken(UserDetails user){ return token(user.getUsername(), refreshDays*24*3600); }
  private String token(String subject, long seconds){ Instant now=Instant.now(); return Jwts.builder().subject(subject).issuedAt(Date.from(now)).expiration(Date.from(now.plusSeconds(seconds))).signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))).compact(); }
  public String subject(String token){ return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))).build().parseSignedClaims(token).getPayload().getSubject(); }
  public boolean valid(String token, UserDetails user){ return subject(token).equals(user.getUsername()); }
}
