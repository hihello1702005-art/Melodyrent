package com.melodyrent.exception;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ApiException.class) ResponseEntity<Map<String,Object>> api(ApiException ex){ return ResponseEntity.status(ex.status()).body(Map.of("timestamp", Instant.now(), "message", ex.getMessage())); }
  @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){ return ResponseEntity.badRequest().body(Map.of("timestamp", Instant.now(), "message", "Validation failed", "errors", ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField()+": "+e.getDefaultMessage()).toList())); }
  @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> all(Exception ex){ return ResponseEntity.status(500).body(Map.of("timestamp", Instant.now(), "message", ex.getMessage())); }
}
