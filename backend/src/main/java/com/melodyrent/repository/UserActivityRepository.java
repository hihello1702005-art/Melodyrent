package com.melodyrent.repository;
import com.melodyrent.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> { List<UserActivity> findTop25ByUserIdOrderByCreatedAtDesc(Long userId); }
