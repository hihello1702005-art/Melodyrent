package com.melodyrent.repository;
import com.melodyrent.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByCustomerIdOrderByCreatedAtDesc(Long customerId);
  @Query("select count(b)>0 from Booking b where b.product.id=:productId and b.status in ('PENDING','CONFIRMED') and b.startDate <= :end and b.endDate >= :start")
  boolean overlaps(@Param("productId") Long productId, @Param("start") LocalDate start, @Param("end") LocalDate end);
}
