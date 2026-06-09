package com.melodyrent.repository;
import com.melodyrent.entity.Product;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query("""
    select p from Product p where p.approved = true and
    (:q is null or lower(p.title) like lower(concat('%', :q, '%')) or lower(p.description) like lower(concat('%', :q, '%'))) and
    (:categoryId is null or p.category.id = :categoryId) and
    (:city is null or lower(p.city) = lower(:city))
  """)
  Page<Product> search(@Param("q") String q, @Param("categoryId") Long categoryId, @Param("city") String city, Pageable pageable);
  List<Product> findTop12ByApprovedTrueOrderByCreatedAtDesc();
  List<Product> findTop12ByCategoryIdAndApprovedTrue(Long categoryId);
}
