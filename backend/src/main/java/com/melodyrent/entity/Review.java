package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="reviews") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Review extends BaseEntity { @ManyToOne(optional=false) private User user; @ManyToOne(optional=false) private Product product; @Column(nullable=false) private Integer rating; @Column(length=1200) private String comment; }
