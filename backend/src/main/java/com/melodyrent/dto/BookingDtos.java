package com.melodyrent.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
public class BookingDtos {
  public record BookingRequest(@NotNull Long productId, @NotNull LocalDate startDate, @NotNull LocalDate endDate) {}
  public record BookingResponse(Long id, Long productId, String productTitle, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice, String status) {}
  public record PriceQuote(Long productId, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice, String explanation) {}
}
