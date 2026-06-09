package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="pricing_rules") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PricingRule extends BaseEntity { @Column(nullable=false) private String name; @Column(nullable=false) private BigDecimal multiplier; private LocalDate startsOn; private LocalDate endsOn; @ManyToOne private Category category; @Builder.Default private Boolean active = true; }
