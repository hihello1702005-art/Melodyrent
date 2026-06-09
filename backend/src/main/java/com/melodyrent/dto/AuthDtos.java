package com.melodyrent.dto;
import com.melodyrent.entity.RoleName;
import jakarta.validation.constraints.*;
import java.util.Set;
public class AuthDtos {
  public record RegisterRequest(@NotBlank String fullName, @Email @NotBlank String email, @Size(min=8) String password, Set<RoleName> roles) {}
  public record LoginRequest(@Email @NotBlank String email, @NotBlank String password) {}
  public record AuthResponse(String accessToken, String refreshToken, String tokenType, UserSummary user) {}
  public record UserSummary(Long id, String fullName, String email, Set<String> roles, Integer rewardPoints, String level) {}
}
