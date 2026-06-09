package com.melodyrent.repository;
import com.melodyrent.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotificationRepository extends JpaRepository<Notification, Long> { }
