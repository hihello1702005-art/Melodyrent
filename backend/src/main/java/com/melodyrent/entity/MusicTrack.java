package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="music_tracks") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MusicTrack extends BaseEntity { @Column(nullable=false) private String title; @Column(nullable=false) private String url; private String artist; private Integer durationSeconds; @ManyToOne(optional=false) private Product product; }
