package com.melodyrent.repository;
import com.melodyrent.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReviewRepository extends JpaRepository<Review, Long> { }
