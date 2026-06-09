package com.melodyrent.mapper;
import com.melodyrent.dto.ProductDtos.*; import com.melodyrent.entity.Product; import org.springframework.stereotype.Component;
@Component
public class ProductMapper {
  public ProductCard toCard(Product p, Double rating){ return new ProductCard(p.getId(), p.getTitle(), p.getDescription(), p.getBasePricePerDay(), p.getCity(), p.getCategory().getName(), p.getOwner().getFullName(), p.getAvailable(), rating, p.getImages().stream().map(i -> new ImageDto(i.getId(), i.getUrl())).toList(), p.getMusicTracks().stream().map(t -> new TrackDto(t.getId(), t.getTitle(), t.getArtist(), t.getUrl(), t.getDurationSeconds())).toList()); }
}
