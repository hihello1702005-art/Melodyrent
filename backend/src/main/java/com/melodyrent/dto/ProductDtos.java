package com.melodyrent.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
public class ProductDtos {
  public record ImageDto(Long id, String url) {}
  public record TrackDto(Long id, String title, String artist, String url, Integer durationSeconds) {}
  public record ProductCard(Long id, String title, String description, BigDecimal basePricePerDay, String city, String category, String ownerName, Boolean available, Double averageRating, List<ImageDto> images, List<TrackDto> musicTracks) {}
  public record ProductRequest(@NotBlank String title, String description, @NotNull BigDecimal basePricePerDay, @NotBlank String city, @NotNull Integer inventory, @NotNull Long categoryId, String model3dUrl, List<String> imageUrls, List<TrackDto> musicTracks) {}
}
