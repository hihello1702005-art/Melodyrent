package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="notifications") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Notification extends BaseEntity { @ManyToOne(optional=false) private User user; @Column(nullable=false) private String title; @Column(length=1000) private String message; @Builder.Default private Boolean readFlag = false; private String deepLink; }
