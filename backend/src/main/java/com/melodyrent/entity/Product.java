package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;
@Entity @Table(name="products") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product extends BaseEntity {
  @Column(nullable=false) private String title;
  @Column(length=2000) private String description;
  @Column(nullable=false) private BigDecimal basePricePerDay;
  @Column(nullable=false) private String city;
  @Column(nullable=false) private Integer inventory;
  @Builder.Default private Boolean approved = false;
  @Builder.Default private Boolean available = true;
  private String model3dUrl;
  @ManyToOne(optional=false) private Category category;
  @ManyToOne(optional=false) private User owner;
  @OneToMany(mappedBy="product", cascade=CascadeType.ALL, orphanRemoval=true) @Builder.Default private List<ProductImage> images = new ArrayList<>();
  @OneToMany(mappedBy="product", cascade=CascadeType.ALL, orphanRemoval=true) @Builder.Default private List<MusicTrack> musicTracks = new ArrayList<>();
}
