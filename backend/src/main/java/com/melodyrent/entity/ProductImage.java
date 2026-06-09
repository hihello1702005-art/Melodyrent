package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="product_images") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductImage extends BaseEntity { @Column(nullable=false) private String url; private String publicId; @ManyToOne(optional=false) private Product product; }
