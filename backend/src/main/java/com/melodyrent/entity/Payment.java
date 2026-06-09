package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name="payments") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment extends BaseEntity { @OneToOne(optional=false) private Booking booking; @Column(nullable=false) private BigDecimal amount; private String provider; private String providerReference; @Enumerated(EnumType.STRING) @Builder.Default private PaymentStatus status = PaymentStatus.PENDING; }
