package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="bookings") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Booking extends BaseEntity {
  @ManyToOne(optional=false) private User customer;
  @ManyToOne(optional=false) private Product product;
  @Column(nullable=false) private LocalDate startDate;
  @Column(nullable=false) private LocalDate endDate;
  @Column(nullable=false) private BigDecimal totalPrice;
  @Enumerated(EnumType.STRING) @Builder.Default private BookingStatus status = BookingStatus.PENDING;
}
