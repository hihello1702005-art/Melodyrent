package com.melodyrent.controller;
import com.melodyrent.dto.AuthDtos.*; import com.melodyrent.service.AuthService; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/auth") @RequiredArgsConstructor
public class AuthController { private final AuthService auth; @PostMapping("/register") AuthResponse register(@Valid @RequestBody RegisterRequest req){ return auth.register(req); } @PostMapping("/login") AuthResponse login(@Valid @RequestBody LoginRequest req){ return auth.login(req); } }
