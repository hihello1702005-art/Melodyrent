package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="wishlists", uniqueConstraints=@UniqueConstraint(columnNames={"user_id","product_id"})) @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Wishlist extends BaseEntity { @ManyToOne(optional=false) private User user; @ManyToOne(optional=false) private Product product; }
