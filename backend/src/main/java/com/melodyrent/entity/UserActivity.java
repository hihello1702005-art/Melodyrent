package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="user_activity") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserActivity extends BaseEntity { @ManyToOne(optional=false) private User user; @ManyToOne private Product product; @Enumerated(EnumType.STRING) private ActivityType type; private String metadata; }
